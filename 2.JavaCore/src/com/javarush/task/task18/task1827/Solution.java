package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            String productName = args[1];
            double price = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            StringBuilder sb = new StringBuilder("");
            sb.append("\n");
            sb.append((String.valueOf(getId(fileName)) + "        ").substring(0, 8));
            sb.append((productName + "                              ").substring(0, 30));
            sb.append((String.valueOf(price) + "        ").substring(0, 8));
            sb.append((String.valueOf(quantity) + "    ").substring(0, 4));
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.close();
        }
    }

    private static int getId(String fileName) {
        int result = Integer.MIN_VALUE;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (Integer.parseInt(line.substring(0, 8).trim()) > result)
                    result = Integer.parseInt(line.substring(0, 8).trim()) + 1;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
