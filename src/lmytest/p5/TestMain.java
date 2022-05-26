package lmytest.p5;

//第5题 填写代码.Web测试搜索百度-湘潭大学(15分)
//        此题的上机环境是:
//        1）Chrome浏览器安装目录为C:\Program Files\Chrome\Application\chrome.exe
//        如果安装目录不是该文件夹，请复制安装目录下的子文件夹“Chrome”到“C:\Program Files\”。
//        2) 驱动程序chromedriver.exe放到C:\WebDriver中(保持英文大小写与此一致)
//
//        此题的上机步骤是:
//        1) 建立一个Java项目,名称可以按题号取名;
//        2) 建立一个测试类, 类的名称为TestMain。这一点非常重要；
//        3) 填代码；
//        4) 提交代码，注意题号要一致。
//        5) 注意只能修改【代码】之处,不能修改其它地方,否则以0分计
//老师的陈年代码，不要尝试运行，为了得分
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMain {

    public static void main(String[] args) {
        // 配置chromedriver的驱动路径
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // 设置chrome浏览器的 exe文件路径
        options.setBinary("C:\\Program Files\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        // 隐式等待时间
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 每次操作时长

        // 运行Chrome浏览器并且打开“百度”网站
        driver.get("http://www.baidu.com");
        // 1. “百度”网站搜索内容输入文本框输入文字“湘潭大学”
        WebElement e = driver.findElementByXPath("/html/body/div[1]/div[1]/div[5]/div/div/form/span[1]/input");// 定位控件“搜索文本框”
        CharSequence []cs={"湘潭大学"};//重点要求
        e.sendKeys(cs);// “搜索文本框”中输入文字“湘潭大学”
        // 2. 单击“百度一下”按钮
        e = driver.findElementByXPath("/html/body/div[1]/div[1]/div[5]/div/div/form/span[2]/input");// 定位“百度”按钮
        e.click();// 单击

    }

}
