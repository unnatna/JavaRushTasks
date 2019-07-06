package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        int sallary = Integer.parseInt(bf.readLine());
        int years = Integer.parseInt(bf.readLine());
        System.out.println(name + " получает " + sallary + " через " + years + " лет.");
    }
}
