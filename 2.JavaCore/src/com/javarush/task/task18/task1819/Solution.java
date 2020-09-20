package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = bufferedReader.readLine();
        String secondFile = bufferedReader.readLine();
        List<Byte> bytes = new ArrayList<Byte>();
        FileInputStream inputStream1 = new FileInputStream(firstFile);
        FileInputStream inputStream2 = new FileInputStream(secondFile);
        while (inputStream2.available() > 0) {
            bytes.add((byte) inputStream2.read());
        }
        inputStream2.close();
        while (inputStream1.available() > 0) {
            bytes.add((byte) inputStream1.read());
        }
        inputStream1.close();
        inputStream1.close();
        FileOutputStream outputStream = new FileOutputStream(firstFile);
        for (byte b:
             bytes) {
            outputStream.write(b);
        }
        outputStream.close();
    }
}
