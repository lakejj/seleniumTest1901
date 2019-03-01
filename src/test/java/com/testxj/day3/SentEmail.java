package com.testxj.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class SentEmail {
    WebDriver driver;
    @BeforeMethod

    public void openIE(){
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        //      System.setProperty("webdriver.firefox.bin","E:\\lx\\seleniumdemo\\drivers\\geckodriver.exe");
        //      driver = new FirefoxDriver();
        driver.get("https://mail.163.com/");

    }
    @AfterMethod
//    public void quiteBrowers(){
//        driver.quit();
//    }

    @Test
    public void sendEmail(){
        RegisterTest.login(driver,"lake_jj","marlboro361");
 //     点击写邮件按钮
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")));


        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
//      邮件地址
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("lake_jj@163.com");
 //     输入主题
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("testselenium");
//      点击上传附件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\360wallpaper.jpg");
//      输入内容
        WebElement framewebe = driver.findElement(By.className("APP-editor-iframe"));

        driver.switchTo().frame(framewebe);

        driver.findElement(By.xpath("/html/body")).sendKeys("test-ttttt");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()=\"发送\"]")).click();
        Boolean bl  = driver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();
        Assert.assertTrue(bl);
    }

}
