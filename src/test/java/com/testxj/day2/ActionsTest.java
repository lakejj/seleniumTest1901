package com.testxj.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class ActionsTest {
    WebDriver webdriver;

    @BeforeMethod
    public void openIE(){
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        webdriver = new InternetExplorerDriver();
 //       driver = new FirefoxDriver();

    }

    @Test
    public void clidkTest(){
        webdriver.get("https://www.baidu.com");
        WebElement newlink = webdriver.findElement(By.name("tj_trnews"));
        newlink.click();
        String newUrl = webdriver.getCurrentUrl();
        Assert.assertEquals(newUrl,"http://news.baidu.com/");
    }

    @Test
    public void sandKeyTest() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        WebElement keys = webdriver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement baiduButton =  webdriver.findElement(By.id("su"));
        baiduButton.click();
        Thread.sleep(3000);
        String headText = webdriver.getTitle();
        Assert.assertEquals(headText,"selenium_百度搜索");
    }

    @Test
    public void clearTest() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        WebElement keys = webdriver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        keys.clear();
        Thread.sleep(3000);
    }

    @Test
    public void getTextTest() {
        webdriver.get("https://www.baidu.com");
        WebElement keys = webdriver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        String text1 = keys.getText();
        keys.clear();
        String text2 = keys.getText();
        Assert.assertEquals(text1,"selenium");
        Assert.assertEquals(text2,"");

    }

    @Test
    public void getTagNameTest() {
        webdriver.get("https://www.baidu.com");
        WebElement keys = webdriver.findElement(By.id("kw"));
        String tagname = keys.getTagName();
        Assert.assertEquals(tagname,"input");

    }

    @Test
    public void getAttributeTest() {
        webdriver.get("https://www.baidu.com");
        String getAttributename = webdriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(getAttributename,"百度一下");

    }

    @Test
    public void isDisplayedTest1() {
        webdriver.get("fils:///E:\\selenium_html\\index.html");
        Boolean  isDisplayed = webdriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(isDisplayed);

    }

    @Test
    public void screenTest() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        webdriver.manage().window().maximize();
        File screenfile =((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenfile,new File("e:\\test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        webdriver.get("https://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);



    }

    @AfterMethod
    public void quiteBrowers(){
        webdriver.quit();
    }

}
