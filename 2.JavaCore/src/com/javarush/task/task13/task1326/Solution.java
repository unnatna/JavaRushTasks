package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader fr = new BufferedReader(new InputStreamReader(System.in));
        FileReader br = null;
        try {
            br = new FileReader(new File(fr.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        fr = new BufferedReader(br);

        ArrayList arr = new ArrayList<Integer>();
        String line;

            try {
                while ((line=fr.readLine())!=null) {
                    if (Integer.parseInt(line) % 2 == 0)
                        arr.add(Integer.parseInt(line));
                }
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        Collections.sort(arr);


        System.out.println(arr);
    }
}
