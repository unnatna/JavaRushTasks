package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        //String fileName1 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/1.txt";
        String fileName2 = reader.readLine();
        //String fileName2 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/2.txt";
        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);

        for (int i = count - 1; i >= 0; i--) {
            outputStream.write(buffer, i, 1);
        }

        inputStream.close();
        outputStream.close();
    }
}
