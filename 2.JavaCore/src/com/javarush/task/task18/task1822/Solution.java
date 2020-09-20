package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Base64;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String row;
            while ((row = reader.readLine()) != null) {
                if (row.split(" ")[0].equals(args[0])) {
                    System.out.println(row);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
