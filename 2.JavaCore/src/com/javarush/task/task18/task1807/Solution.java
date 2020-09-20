package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1805/1.txt";
        FileInputStream inputStream = new FileInputStream(fileName);
        int result = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == (int)',')
                result++;
        }
        inputStream.close();
        System.out.println(result);
    }
}
