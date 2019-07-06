package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        int days;
        if (year % 400 == 0)
            days = 366;
        else if ((year % 400) % 100 == 0)
            days = 365;
        else if (((year % 400) % 100) % 4 == 0 )
            days = 366;
        else
            days = 365;

        System.out.println("количество дней в году: " + days);
    }
}