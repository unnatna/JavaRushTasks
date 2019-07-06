package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] bigInts = new int[20], firstHalf = new int[10], secondHalf = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            bigInts[i] = Integer.parseInt(br.readLine());
            if (i >= 10)
                secondHalf[i - 10] = bigInts[i];
            else
                firstHalf[i] = bigInts[i];
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(secondHalf[i]);
        }
    }
}
