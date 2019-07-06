package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arrayList.add(br.readLine());
        }
        int longString = arrayList.get(0).length();
        int shortString = arrayList.get(0).length();
        for (int i = 0; i < 10; i++) {
            if (arrayList.get(i).length() > longString)
                longString = arrayList.get(i).length();
            if (arrayList.get(i).length() < shortString)
                shortString = arrayList.get(i).length();
        }

        for (int i = 0; i < 10; i++) {
            if ((arrayList.get(i).length() == shortString) || (arrayList.get(i).length() == longString)) {
                System.out.println(arrayList.get(i));
                break;
            }
        }
    }
}
