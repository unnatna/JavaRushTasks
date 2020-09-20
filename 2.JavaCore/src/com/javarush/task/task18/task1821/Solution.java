package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        //fileName = "/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1821/1.txt";
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> sorted = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) {
                int data = inputStream.read();

                if (!sorted.contains(data))
                    sorted.add(data);

                if (map.containsKey(data))
                    map.put(data, map.get(data) + 1);
                else
                    map.put(data, 1);
            }
            Collections.sort(sorted);

            for (int item:
                 sorted) {
                System.out.println((char)item + " " + map.get(item));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
