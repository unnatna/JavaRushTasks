package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            List<String> rows = new ArrayList<>();
            reader.close();

            BufferedReader frider = new BufferedReader(new FileReader(fileName));
            while (frider.ready()) {
                String line = frider.readLine();
                if (Integer.parseInt(args[1]) != Integer.parseInt(line.substring(0, 8).trim()))
                    rows.add(line);
                else
                    switch (args[0].toLowerCase()) {
                        case "-u":
                            rows.add(String.format("%-8s%-30s%-8.2f%-4d" , args[1], args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4])));
                            break;
                        case "-d":
                            break;
                    }

            }
            frider.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String line:
                 rows) {
                writer.write(line + "\n");
            }

            writer.close();
        }
    }
}
