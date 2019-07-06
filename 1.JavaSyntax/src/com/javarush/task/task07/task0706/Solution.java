package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int[] ints = new int[15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chet = 0, nechet = 0;
        for (int i = 0; i < 15; i++) {
            ints[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0)
                chet += ints[i];
            else
                nechet += ints[i];
        }

        System.out.println("В домах с " + (nechet > chet?"не":"") + "четными номерами проживает больше жителей.");
    }
}
