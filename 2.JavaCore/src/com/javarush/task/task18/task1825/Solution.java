package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<String>();
        while (true) {
            String fileName = bufferedReader.readLine();
            if (fileName.toLowerCase().equals("end"))
                break;
            files.add(fileName);
        }
        bufferedReader.close();

        String outFileName = files.get(0).split(".part")[0];
        FileOutputStream outputStream = new FileOutputStream(outFileName, true);
        FileInputStream inputStream = null;

        for (int i = 1; i <= files.size(); i++) {
            for (String file:
                 files) {
                if (Integer.parseInt(file.split(".part")[1]) == i) {
                    inputStream = new FileInputStream(file);
                    byte[] buffer = new byte[inputStream.available()];
                    int size = inputStream.read(buffer);
                    outputStream.write(buffer);
                    inputStream.close();
                }
            }
        }
        outputStream.close();
    }
}
