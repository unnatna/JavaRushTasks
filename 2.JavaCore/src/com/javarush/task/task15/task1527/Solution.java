package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String url = reader.readLine();
            ArrayList<String> params = new ArrayList<String>();
            String value = "";
            for (String param :
                    url.split("\\?")[1].split("&")) {
                if (param.split("=")[0].equals("obj")) {
                    value = param.split("=")[1];
                }
                params.add(param.split("=")[0] + " ");
            }
            System.out.println(String.join("", params));
            if (!value.equals("")) {
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
