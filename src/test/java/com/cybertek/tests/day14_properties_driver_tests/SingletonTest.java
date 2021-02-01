package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
        String s1 = Singleton.getInstance();
        System.out.println("--------------------------------------");
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test1() throws InterruptedException {


        Driver.get().get("http://www.google.com");

        Thread.sleep(2000);


    }

    @Test
    public void test2(){

        Driver.get().get("http://www.amazon.com");

    }
}
