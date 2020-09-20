package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String fileName = reader.readLine();
                if (fileName.toLowerCase().equals("exit")) {
                    reader.close();
                    break;
                }
                Thread thread = new ReadThread(fileName);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.inputStream = new FileInputStream(fileName);
            this.file = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        private FileInputStream inputStream;
        private String file;
        @Override
        public void run() {
            Map<Integer, Integer> subResult = new HashMap<>();
            try {
                while (inputStream.available() > 0) {
                    int data = inputStream.read();
                    if (subResult.containsKey(data))
                        subResult.put(data, subResult.get(data) + 1);
                    else
                        subResult.put(data, 1);
                }
                int max = Integer.MIN_VALUE;
                int byten = 0;
                for (Map.Entry<Integer, Integer> entry:
                     subResult.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        byten = entry.getKey();
                    }
                }
                resultMap.put(this.file, byten);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
