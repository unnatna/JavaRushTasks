package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] ints = new int[20];
        for (int i = 0; i < 20; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }

        maximum = ints[0];
        minimum = ints[0];

        for (int i = 0; i < 20; i++) {
            if (ints[i] < minimum)
                minimum = ints[i];
            if (ints[i] > maximum)
                maximum = ints[i];
        }

        System.out.print(maximum + " " + minimum);
    }
}
