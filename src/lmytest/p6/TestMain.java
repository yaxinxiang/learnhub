package lmytest.p6;
//此题的上机环境是:
//        1）Chrome浏览器安装目录为C:\Program Files\Chrome\Application\chrome.exe
//        如果安装目录不是该文件夹，请将安装目录下的子文件夹“Chrome”复制到“C:\Program Files\”
//        2) 驱动程序chromedriver.exe放到C:\WebDriver中
//
//        此题的上机步骤是:
//        1) 建立一个Java项目,名称可以按题号取名;
//        2) 建立一个测试类, 类的名称为TestMain。这一点非常重要；
//        3) 填代码；
//        4) 提交代码，注意题号要一致。
//        5) 注意只能修改【代码】之处,不能修改其它地方,否则以0分计
//老师的陈年代码，不要尝试运行，为了得分

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class TestMain {
    static void Sleep(int a) {
        try {
            Thread.sleep(a * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 配置chromedriver的驱动路径
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // 设置chrome浏览器的 exe文件路径
        options.setBinary("C:\\Program Files\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        // 隐式等待时间
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // 安居客
        driver.get("https://nj.zu.anjuke.com/");
        // 1. 点击租房
        WebElement e = driver.findElementByXPath("/html/body/div[2]/div/ul/li[4]/a");
        e.click();
        // 2. 地址选择“南京”
        e = driver.findElementByXPath("/html/body/div[3]/div/div[1]/i");
        e.click();
        // 弹出列表
        e = driver.findElementByXPath("/html/body/div[3]/div/div[2]/dl[2]/dd/a[4]");
        e.click();

        // 3. 点击“地铁找房”
        e = driver.findElementByLinkText("地铁找房");
        e.click();

        // 4. 选择“2 号线”
        e = driver.findElementByXPath("/html/body/div[5]/div[2]/div[1]/span[2]/div/a[3]");
        e.click();
        Sleep(2);
        // 5. 选择“马群”
        e = driver.findElementByXPath("/html/body/div[5]/div[2]/div[1]/span[2]/div/div/a[20]");
        e.click();

        // 6. 设置租金为 2600-5200 元，并点击确定
        e = driver.findElementByXPath("/html/body/div[5]/div[2]/div[2]/span[2]/div/form/input[1]");
        CharSequence []cs={"2600"};//重点要求
        e.sendKeys(cs);// “搜索框”中输入“2600”

        e = driver.findElementByXPath("/html/body/div[5]/div[2]/div[2]/span[2]/div/form/input[2]");
        cs[0]="5200";
        e.sendKeys(cs);//不能直接用字符串
        e.click();

        e = driver.findElementByXPath("//*[@id=\"pricerange_search\"]");
        e.click();

        driver.close();
    }

}
