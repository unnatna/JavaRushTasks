package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(br.readLine());
        }
        int min = strings.get(1).length();
        for (String s: strings) {
            if (s.length() < min)
                min = s.length();
        }
        for (String s: strings) {
            if (s.length() == min)
                System.out.println(s);
        }
    }
}
