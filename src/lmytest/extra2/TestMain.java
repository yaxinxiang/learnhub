package lmytest.extra2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        registerTest(driver);
    }

    public static void registerTest(ChromeDriver driver){
        driver.get("https://sahitest.com/demo/training/register.htm");
        WebElement e = driver.findElementByName("username");
        e.sendKeys("yaxin");
        e = driver.findElementByName("password");
        e.sendKeys("password");
        e = driver.findElementByName("password2");
        e.sendKeys("password");
        e = driver.findElementByXPath("/html/body/center/div/form/div/table/tbody/tr[4]/td[2]/input[1]");
        e.click();
        e = driver.findElementByName("address");
        e.sendKeys("湘潭大学");
        e = driver.findElementByName("billaddress");
        e.sendKeys("billaddress湘潭大学");
        e = driver.findElementByName("state");
        Select select = new Select(e);
        select.selectByIndex(1);
        e = driver.findElementByName("agree");
        e.click();
        e = driver.findElementByXPath("/html/body/center/div/form/input[2]");
        e.click();
        driver.switchTo().alert().accept();
        e = driver.findElementByXPath("/html/body/center/div/form/input[3]");
        e.click();
        driver.switchTo().alert().dismiss();
        e = driver.findElementByLinkText("Go back to login");
        e.click();
    }
}
