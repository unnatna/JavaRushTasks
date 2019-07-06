package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    static int a, b, c;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

            if (b > a)
                a = a + b - (b = a);

            if (c > b)
                c = c + b - (b = c);

            if (b > a)
                a = a + b - (b = a);

        System.out.println(a + " " + b + " " + c);

    }

}
