package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        //FileInputStream inputStream = new FileInputStream("/Users/unnatna/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1816/1.txt");
        int count = 0;
        //Pattern pattern = new Pattern("[a-z][A-Z]");
        //System.out.println("s".matches("[A-Za-z]"));
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            //System.out.println(String.valueOf(data));
            if (String.valueOf((char)data).toLowerCase().matches("[a-z]"))
                count++;
        }
        inputStream.close();
        System.out.println(count);
    }
}
