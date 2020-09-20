package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        //FileInputStream inputStream = new FileInputStream("/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1817/1.txt");
        double allCount = 0;
        double spaceCount = 0;
        while (inputStream.available() > 0) {
            char symbol = (char) inputStream.read();
            if (String.valueOf(symbol).equals(" "))
                spaceCount++;
            allCount++;
        }
        System.out.println(Math.round(spaceCount / allCount * 10000.0) / 100.0);
        inputStream.close();
    }
}
