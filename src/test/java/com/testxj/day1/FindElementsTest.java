package com.testxj.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver webdriver;
    @BeforeMethod
    public void openIE(){
        System.setProperty("webdriver.ie.driver","E:\\lx\\seleniumdemo\\drivers\\IEDriverServer.exe");
        webdriver = new InternetExplorerDriver();

    }

    @Test
    public void byIDTest(){
        webdriver.get("https://www.baidu.com");
        webdriver.findElement(By.id("kw"));
    }

    @Test
    public void byName(){
        webdriver.get("https://www.baidu.com");
        webdriver.findElement(By.name("wd"));
    }

    @Test
    public void byClassName() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        webdriver.findElement(By.className("s_ipt"));
        Thread.sleep(3000);
    }

    @Test
    public void byLinkText() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        webdriver.findElement(By.partialLinkText("新"));
        Thread.sleep(3000);
    }

    @Test
    public void byTagName() throws InterruptedException {
        webdriver.get("https://www.baidu.com");

        List<WebElement> list = webdriver.findElements(By.tagName("input"));
        System.out.print(list.size());
        Thread.sleep(3000);
    }

    @Test
    public void byXpath() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        String text1;
        List<WebElement>  list = webdriver.findElements(By.xpath("/html/body/div[1]/div[1]/div/div[3]/a"));
        for (int i = 0; i <list.size() ; i++) {
            text1 = list.get(i).getText();
            System.out.print(text1);
        }

        Thread.sleep(3000);
    }

    @Test
    public void bycssSelect() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        webdriver.findElement(By.cssSelector("#kw"));
        Thread.sleep(3000);
    }

    @AfterMethod
    public void quiteBrowers(){
        webdriver.quit();
    }
}
