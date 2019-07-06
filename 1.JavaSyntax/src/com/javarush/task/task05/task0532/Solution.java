package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        //напишите тут ваш код
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());
            if (m > maximum)
                maximum = m;
        }

        System.out.println(maximum);
    }
}
