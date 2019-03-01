package com.testxj.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;

public class RegisterTest {
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
    public void quiteBrowers(){

        driver.quit();
    }

    @Test
    public void loginSucessTest(){
   /*
        driver.switchTo().frame(element);
        String emailName = "lake_jj";
        driver.findElement(By.name("email")).sendKeys(emailName);
        driver.findElement(By.name("password")).sendKeys("marlboro361");
        driver.findElement(By.id("dologin")).click();
 */
        RegisterTest.login(driver,"lake_jj","marlboro361");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spnUid")));
        String assertsry = driver.findElement(By.id("spnUid")).getText();
        Assert.assertEquals(assertsry,"lake_jj@163.com");

    }

    @Test
    public void loginErrorTest(){

        RegisterTest.login(driver,"rqwe23423","dsf34234");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String assertsry = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(assertsry,"帐号或密码错误");

    }


    public static void login( WebDriver longindriver, String emailName, String pwd){
        WebElement element = longindriver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe"));
        longindriver.switchTo().frame(element);
        longindriver.findElement(By.name("email")).sendKeys(emailName);
        longindriver.findElement(By.name("password")).sendKeys(pwd);
        longindriver.findElement(By.id("dologin")).click();

    }

    public static void login2( WebDriver longindriver, String emailName, String pwd){
        WebElement element = longindriver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe"));
        longindriver.switchTo().frame(element);
        longindriver.findElement(LoginPage.emailInput).sendKeys(emailName);
        longindriver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        longindriver.findElement(LoginPage.loginButton).click();

    }
}
