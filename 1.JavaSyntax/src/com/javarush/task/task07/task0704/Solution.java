package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] ints = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(ints[9 - i]);
        }
    }
}

