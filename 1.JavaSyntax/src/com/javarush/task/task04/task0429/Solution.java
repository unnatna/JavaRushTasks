package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int lessCount = 0, moreCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                continue;
            else if (n < 0)
                lessCount++;
            else
                moreCount++;
        }
        System.out.println("количество отрицательных чисел: " + lessCount);
        System.out.println("количество положительных чисел: " + moreCount);
    }
}
