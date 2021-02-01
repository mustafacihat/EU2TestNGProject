package com.cybertek.tests.day14_properties_driver_tests;

public class Singleton {

    //singleton class will have private constructor
    //it means othe classes cannot create object of tihs class

    private Singleton() {
    }

    private static String str;


    public static String getInstance() {


        //signleton class will have private constructor
        //it means other classes cannot create object of this class
        //if str has no value, initialize it and return it"st
        if (str == null) {
            System.out.println("str is null. assgining value to it");
            str = "somevalue";
        } else {
            //if it has value just return it
            System.out.println("it has value us return it ");
        }

        return str;


    }
}
