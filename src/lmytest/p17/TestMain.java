package lmytest.p17;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMain {
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://anjuke.com/ask/");
        sleep(2);
        WebElement e = driver.findElementByXPath("/html/body/div[3]/div/div/div[2]/form/div/input");
        e.sendKeys("蜜蜂");
        e.clear();
        e = driver.findElementByXPath("/html/body/div[3]/div/div/div[2]/form/button");
        e.click();
    }
}

