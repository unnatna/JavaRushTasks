package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String path = bufferedReader.readLine();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            while (1 == 1) {
                String string = bufferedReader.readLine();
                if (string.equals("exit"))
                    break;
                else {
                    bufferedWriter.write(string + "\n");
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
