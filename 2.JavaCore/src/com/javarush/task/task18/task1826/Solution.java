package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(args[0]);
        try {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            System.out.println(count);
            switch (args[0]) {
                case "-d":
                    outputStream.write(decodeData(buffer), 0, count);
                    break;
                case "-e":
                    outputStream.write(encodeData(buffer), 0, count);
                    break;
            }
            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] encodeData(byte[] buffer) {
        byte[] result = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            result[i] = buffer[buffer.length - 1 - i];
        }
        return result;
    }

    private static byte[] decodeData(byte[] buffer) {
        return encodeData(buffer);
    }

}
