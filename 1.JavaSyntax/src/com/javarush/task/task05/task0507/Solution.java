package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int sum = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1)
                break;
            else {
                sum += n;
                count++;
            }
        }
        System.out.println(count==0?"":(double) sum / count);
    }
}

