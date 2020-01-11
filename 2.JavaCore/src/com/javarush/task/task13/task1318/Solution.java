package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String path = bufferedReader.readLine();
            FileInputStream inputStream = new FileInputStream(path);
            while (inputStream.available() > 0) {

                System.out.print((char) inputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
