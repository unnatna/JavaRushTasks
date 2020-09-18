package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader = new BufferedReader(new FileReader(fileName1));
            while (reader.ready()) {
                allLines.add(reader.readLine());
            }
            reader = new BufferedReader(new FileReader(fileName2));
            while (reader.ready()) {
                forRemoveLines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            List<String> clearedLines = new ArrayList<>();
            for (int i = 0; i < allLines.size(); i++) {
                if (!forRemoveLines.contains(allLines.get(i)))
                    clearedLines.add(allLines.get(i));
            }
            allLines = clearedLines;
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
