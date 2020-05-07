package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test(){

        //C:\Users\Mugetsu\IdeaProjects\EU2TestNGProject\src\test\resources\testfile.txt

        //getting project location/path dynamically
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\resources\\testfile.txt";

        System.out.println("projectPath = " + projectPath);
        System.out.println("relativePath = " + relativePath);
        String filePath = projectPath + "/"+relativePath;
        System.out.println("filePath = " + filePath);
    }
}
