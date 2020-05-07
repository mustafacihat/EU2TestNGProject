package com.cybertek.tests.day1_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(System.getProperty("os.name"));
        System.out.println("===========================================");
        Faker faker = new Faker();


        System.out.println("1. " + faker.harryPotter().character());

        for (int i = 0; i < 10; i++) {
            System.out.println(faker.name().fullName());
        }


        System.out.println(faker.finance().creditCard((CreditCardType.AMERICAN_EXPRESS)));
        System.out.println(faker.overwatch().hero());

    }
}
