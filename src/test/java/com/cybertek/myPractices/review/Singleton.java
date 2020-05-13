package com.cybertek.myPractices.review;

public class Singleton {

    public static void main(String[] args) {

        String instance1 = getInstance();
        System.out.println("instance1 = " + instance1);
        String instance2 = getInstance();
        Singleton.close();
        String str = Singleton.str;
        System.out.println(str);

    }
    private Singleton(){}

    private static String str;


    public static String getInstance(){

        if (str == null){
            System.out.println("str is null");
            str = "newvalue";
        }else{
            System.out.println("str has value");
        }
        return str;
    }

    public static void close(){
        if (str !=null){
            str = null;
        }
    }
}
