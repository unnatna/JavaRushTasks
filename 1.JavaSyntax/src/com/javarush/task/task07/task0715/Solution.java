package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/*
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("мама", "мыла", "раму"));

        list.add(1, "именно");
        list.add(3, "именно");
        list.add(5, "именно");

        for (String s:
             list) {
            System.out.println(s);
        }
    }
}
