package lmytest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class MyPlayTest {
    private static final String chromeDriverPath = "C:\\WebDriver\\chromedriver.exe";
    private static final String chromePath = "C:\\Program Files\\Chrome\\Application\\chrome.exe";
    private static final String studentID = "201905556806";
    private static final String realName = "向亚欣";
    private static final String classAndGrade = "软件工程2班";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------登录练题自动化系统----------");
        String num;
        while(true){
            System.out.println("请输入需要练习的题号（1-19）或者输入quit退出！：");
            while(true){
                num = sc.nextLine();
                if(num.equals("quit")){
                    return;
                }
                if(isValidNum(num)){
                    break;
                }
                System.out.println("请输入合法数字！（1-19）或输入quit退出");
            }
            doLmyTest2022(Integer.parseInt(num));
        }
    }

    public static ChromeDriver getChromeDriver(String chromeDriverPath, String chromePath){
        //配置webdriver系统路径
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        //配置浏览器路径：
        options.setBinary(chromePath);
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public static void doLmyTest2022(int questionNumber){
        ChromeDriver driver = getChromeDriver(chromeDriverPath, chromePath);
        loginLmyTest2022(driver, studentID, realName, classAndGrade);
        chooseQuestion(driver, questionNumber);
    }

    public static void loginLmyTest2022(ChromeDriver driver, String studentID, String realName, String classAndGrade){
        driver.get("http://172.16.72.194:8888/TestT2022/");
        sleep(1);
        WebElement e = driver.findElementByLinkText("鼠标单击此处开始练习");
        e.click();
        sleep(1);
        e = driver.findElementByName("UserID");
        e.sendKeys(studentID);
        e = driver.findElementByName("Name");
        e.sendKeys(realName);
        e = driver.findElementByXPath("/html/body/div[3]/div/form/h4[6]");
        String seatNum = findIPSuffix(e.getText());
        e = driver.findElementByName("PCID");
        e.sendKeys(seatNum);
        e = driver.findElementByName("SelectClassName");
        Select select = new Select(e);
        select.selectByVisibleText(classAndGrade);
        e = driver.findElementByXPath("/html/body/div[3]/div/form/p[1]/input");
        e.click();
    }

    public static void chooseQuestion(ChromeDriver driver, int questionNumber){
        Select exNo = new Select(driver.findElementByName("exNo"));
        exNo.selectByIndex(questionNumber - 1);
        driver.findElementByXPath("/html/body/div[3]/div/div[1]/form[2]/center/input").click();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String findIPSuffix(String strWithIPLast){
        int i = strWithIPLast.lastIndexOf(".") + 1;
        int j = i;
        while(strWithIPLast.charAt(j) >= '0' && strWithIPLast.charAt(j) <= '9'){
            j++;
        }
        return strWithIPLast.substring(i, j);
    }

    public static boolean isValidNum(String num){
        if(num.length() > 2){
            return false;
        }
        if(num.length() == 2){
            if(num.charAt(0) > '1'){
                return false;
            }
            if(num.charAt(1) < '0' || num.charAt(1) > '9'){
                return false;
            }
        }else if(num.length() == 1){
            if(num.charAt(0) < '0' || num.charAt(0) > '9'){
                return false;
            }
        }
        return true;
    }
}
