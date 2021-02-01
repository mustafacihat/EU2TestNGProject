package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo2 {


    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //It accepts two arguments
        //Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open(sheetname)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("qa3short = " + qa3short);

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //get al data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        System.out.println(dataList);
        System.out.println("====================================================");
        for (Map<String, String> stringStringMap : dataList) {
            System.out.println(stringStringMap);
        }

        //get Nona as a value
        System.out.println(dataList.get(2).get("firstname"));

        //get Harber as a value
        System.out.println(dataList.get(8).get("lastname"));

        //get all data in 2d array
        String[][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));
    }

}
