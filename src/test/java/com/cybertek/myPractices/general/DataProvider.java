package com.cybertek.myPractices.general;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] testData() {

        Object [][] obj = new Object [2][2];
        obj [0][0]= "cihat";
        obj [0][1]= "123";

        obj [1][0]= "ahmet";
        obj [1][1]= "456";



        return obj;

    }

    @Test(dataProvider = "testData")
    public void test(String s1, String s2) {
        System.out.println(s1 + " --" + s2 );

    }
    @org.testng.annotations.DataProvider
    public Object[][] testData1() {

        Object [][] obj = new Object [2][2];
        obj [0][0]= "hatice";
        obj [0][1]= 123;

        obj [1][0]= "ayşe";
        obj [1][1]= 1;


        return obj;

    }

    @Test(dataProvider = "testData1")
    public void test1(String s1, int s2) {
        System.out.println(s1 + " --" + s2 );

    }
}
