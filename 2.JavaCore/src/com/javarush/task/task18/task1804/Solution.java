package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1804/1.txt";
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int min = inputStream.available();
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (map.containsKey(data))
                map.put(data, map.get(data) + 1);
            else
                map.put(data, 1);
        }

        for (Map.Entry<Integer, Integer> entry:
             map.entrySet()) {
            if (entry.getValue() < min)
                min = entry.getValue();
        }

        for (Map.Entry<Integer, Integer> entry:
             map.entrySet()) {
            if (entry.getValue() == min) {
                System.out.print(entry.getKey());
                System.out.print(" ");
            }
        }

        inputStream.close();
    }
}
