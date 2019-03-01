package com.testxj.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {
    @BeforeTest
    public void beforeTese01(){
        System.out.println("zheshi @beforeTese 1");
    }

    @BeforeMethod
    public void beformethod(){
        System.out.println("zheshi @beformethod 1");
    }


    @Test
    public void testCase1(){
        System.out.println("zheshi @test 1");
    }

    @Test
    public void testCase2(){
        System.out.println("zheshi @test 2");
    }
}
