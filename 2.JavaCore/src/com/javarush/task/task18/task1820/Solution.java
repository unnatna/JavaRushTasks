package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = null;
        String fileName2 = null;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            //fileName1 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/1.txt";
            //fileName2 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/2.txt";

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
            FileOutputStream outputStream = new FileOutputStream(fileName2);
            boolean isFirst = true;
            for (String item:
                 reader.readLine().split(" ")) {
                if (isFirst) {
                    outputStream.write(String.valueOf(Math.round(Double.parseDouble(item))).getBytes());
                    isFirst = false;
                } else
                    outputStream.write((" " + Math.round(Double.parseDouble(item))).getBytes());
                }
            reader.close();
            outputStream.close();
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
