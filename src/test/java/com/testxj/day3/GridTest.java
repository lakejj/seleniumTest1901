package com.testxj.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class GridTest {
    @Test
    public void testIe() throws  MalformedURLException,InterruptedException {
        DesiredCapabilities ieDC = internetExplorer();
        WebDriver driver;
        driver = new RemoteWebDriver(new URL("http://192.168.0.106:6666/wd/hub"), ieDC);
        driver.get("https://baidu.com/");
        Thread.sleep(5000);
        driver.quit();
    }

    @DataProvider(name = "data2")
    public Object[][] test1(){
        return new Object[][]{
                {"iebrowser","http://192.168.0.106:6666"},
                {"firefox","http://192.168.0.106:5555"}};
    }

    @Test(dataProvider = "data2")
    public void testGrid2(String browser,String url) throws  MalformedURLException,InterruptedException {
        DesiredCapabilities dc = null;
        if(browser.contentEquals("iebrowser")){
            dc = DesiredCapabilities.internetExplorer();
        }else if(browser.contentEquals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            System.out.print("error");
        }
        WebDriver driver;
        driver = new RemoteWebDriver(new URL(url + "/wd/hub"), dc);
        driver.get("https://baidu.com/");
        Thread.sleep(5000);
        driver.quit();
    }

}
