package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            String s = br.readLine();
            if (s.toLowerCase().equals("сумма"))
                break;
            else {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println(sum);
    }
}
