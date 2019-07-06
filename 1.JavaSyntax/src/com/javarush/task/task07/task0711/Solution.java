package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            arrayList.add(br.readLine());
        }

        for (int i = 0; i < 13; i++) {
            String newString = arrayList.get(4);
            arrayList.remove(4);
            arrayList.add(0, newString);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
