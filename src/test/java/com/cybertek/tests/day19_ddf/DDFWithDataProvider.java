package com.cybertek.tests.day19_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {


    @DataProvider
    public Object[][] testData() {

        return new String[][]{{"Person of Interest", "10"}, {"Killing Eve", "8"}, {"Got", "9"}, {"Breaking Bad", "10"}, {"Dark", "9"}, {"Dexter", "9"}, {"Friends", "10"}};
    }

    @Test(dataProvider = "testData")
    public void test1(String tvShow, String rating){
        System.out.println("Tv show: " + tvShow + " has rating " + rating);
    }

}
