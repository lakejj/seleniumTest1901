package com.testxj.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrowerTest {
    WebDriver driver;

    @BeforeMethod
    public void BrowserActionTest(){
 //       System.setProperty("webdriver.ie.driver","E:\\lx\\seleniumdemo\\drivers\\IEDriverServer.exe");
 //       driver = new InternetExplorerDriver();
//          firefox 47以后版本需要对应的驱动，需要添加下面的代码
//        System.setProperty("webdriver.firefox.bin","E:\\lx\\seleniumdemo\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();

    }

    @Test
    public void openIE() throws InterruptedException{
        driver.get("https://baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void openFirefos(){
        driver.close();

    }

    @Test
    public void getTest() throws InterruptedException {
       driver.get("https://www.baidu.com");

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

    }

    @Test
    public void winTest() throws InterruptedException {
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public void winTest1() throws InterruptedException {
        driver.get("file:///E:\\selenium_html\\index.html");
        Thread.sleep(3000);
        String surl = driver.getCurrentUrl();
        System.out.println("ok");
        Assert.assertEquals(surl,"https://www.baidu.com/");

    }

    @AfterMethod
    public void closedBrower(){
        driver.quit();
    }
}
