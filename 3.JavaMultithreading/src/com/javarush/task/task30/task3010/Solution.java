package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int result = 0;
        BigInteger value = null;
        try {
            String number = args[0];

            for (int i = 2; i < 40; i++) {
                try {
                    value = new BigInteger(number, i);
                    result = i;
                    break;
                } catch (NumberFormatException e) {

                }
            }

            System.out.println(result != 0 ? result : "incorrect");

        } catch (Exception e) {

        }
    }
}