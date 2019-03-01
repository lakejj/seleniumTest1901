package com.testxj.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class AlertTest {

    WebDriver webdriver;

    @BeforeMethod
    public void openIE(){
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        webdriver = new InternetExplorerDriver();

    }


    @Test
    public void alertTest() throws InterruptedException {
        webdriver.get("file:///E:\\selenium_html\\index.html");
        webdriver.findElement(By.className("alert")).click();
        Alert alert1 = webdriver.switchTo().alert();
        Thread.sleep(3000);
        alert1.accept();
        Thread.sleep(3000);
    }





    @Test
    public void confirmTest() throws InterruptedException {
        webdriver.get("file:///E:\\selenium_html\\index.html");
        Thread.sleep(10000);
        webdriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert1 = webdriver.switchTo().alert();
        alert1.dismiss();
        Thread.sleep(3000);
        alert1.accept();
    }


    @AfterMethod
    public void quiteBrowers(){
        webdriver.quit();
    }


}
