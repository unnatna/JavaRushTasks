package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();
            FileInputStream inputStream1 = new FileInputStream(fileName2);
            FileInputStream inputStream2 = new FileInputStream(fileName3);
            FileOutputStream outputStream = new FileOutputStream(fileName1, true);
            byte[] buffer = new byte[1000];
            while (inputStream1.available() > 0) {
                int count = inputStream1.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream1.close();
            while (inputStream2.available() > 0) {
                int count = inputStream2.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream2.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
