package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        //String fileName1 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/1.txt";
        String fileName2 = reader.readLine();
        //String fileName2 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/2.txt";
        String fileName3 = reader.readLine();
        //String fileName3 = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/3.txt";

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream2 = new FileOutputStream(fileName2);
        FileOutputStream outputStream3 = new FileOutputStream(fileName3);
        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);
        int offset = count / 2;
        if (count % 2 == 0)
            outputStream2.write(buffer, 0, count / 2);
        else {
            outputStream2.write(buffer, 0, count / 2 + 1);
            offset++;
        }

        outputStream3.write(buffer, offset, count / 2);

        inputStream.close();
        outputStream2.close();
        outputStream3.close();

    }
}
