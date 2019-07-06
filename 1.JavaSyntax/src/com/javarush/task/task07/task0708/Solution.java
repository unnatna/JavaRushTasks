package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(br.readLine());
        }
        int max = strings.get(1).length();
        for (String s: strings) {
            if (s.length() > max)
                max = s.length();
        }
        for (String s: strings) {
            if (s.length() == max)
                System.out.println(s);
        }


    }
}
