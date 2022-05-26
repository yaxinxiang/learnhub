package lmytest.extra1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://sahitest.com/demo/training/login.htm");
        WebElement e = driver.findElementByName("user");
        e.sendKeys("test");
        e = driver.findElementByName("password");
        e.sendKeys("secret");
        e = driver.findElementByClassName("button");
        e.click();
        sleep(1);
        e = driver.findElementByXPath("/html/body/center/form/div/table/tbody/tr[2]/td[4]/input");
        e.sendKeys("1");
        e = driver.findElementByXPath("/html/body/center/form/div/table/tbody/tr[3]/td[4]/input");
        e.sendKeys("2");
        e = driver.findElementByXPath("/html/body/center/form/div/table/tbody/tr[4]/td[4]/input");
        e.sendKeys("3");
        e = driver.findElementByXPath("/html/body/center/form/div/input[1]");
        e.click();
        e = driver.findElementByXPath("/html/body/center/form/div/input[2]");
        e.click();
        e = driver.findElementByXPath("/html/body/center/form/div/input[3]");
        e.click();
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
