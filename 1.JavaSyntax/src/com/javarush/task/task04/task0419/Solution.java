package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 0;
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n >= min)
                min = n;
        }
        System.out.println(min);
    }
}
