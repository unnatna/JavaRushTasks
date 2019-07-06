package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                sum += n;
                break;
            }
            else
                sum += n;
        }
        System.out.println(sum);
    }
}
