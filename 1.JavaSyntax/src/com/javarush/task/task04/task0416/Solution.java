package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double minutes = Double.parseDouble(br.readLine());
        if (minutes % 5 < 3)
            System.out.println("зелёный");
        else if (minutes % 5 < 4)
            System.out.println("жёлтый");
        else
            System.out.println("красный");
    }
}