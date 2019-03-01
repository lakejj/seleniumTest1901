package com.testxj.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    @Test
    public void assertEquelTest(){
        String a ="adcdf";
        String b ="adcdf111" ;


        Assert.assertEquals(a,b, "a<>b");
    }
    @Test
    public void assertNoEqualtest1(){
        int a =1;
        int b=1;
        Assert.assertNotEquals(a,b,"a=b");
    }

    @Test
    public void assertNullTest2(){
        String  a = null;
        Assert.assertNotNull(a);
    }
}
