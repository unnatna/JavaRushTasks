package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        String [] chars = string.split("");
        System.out.print(chars[0].toUpperCase());
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1].equals(" "))
                System.out.print(chars[i].toUpperCase());
            else
                System.out.print(chars[i]);
        }

    }
}
