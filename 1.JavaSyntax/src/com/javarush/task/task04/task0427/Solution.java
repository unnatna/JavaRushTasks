package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String result = "число";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n >= 1 && n <= 999) {
            if (n / 100 > 0)
                result = "трехзначное " + result;
            else if (n / 10 > 0)
                result = "двузначное " + result;
            else
                result = "однозначное " + result;


            if (n % 2 == 0)
                result = "четное " + result;
            else
                result = "нечетное " + result;

            System.out.println(result);
        }
    }
}
