package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        double c = Double.parseDouble(br.readLine());
        if (a == b && a == c)
            System.out.println(a + " " + a + " " + a);
        else if (a == b || a == c)
            System.out.println(a + " " + a);
        else if (a == b || b == c)
            System.out.println(b + " " + b);
    }
}