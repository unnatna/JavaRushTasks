package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>(){
            {
                put("January", 1);
                put("February", 2);
                put("March", 3);
                put("April", 4);
                put("May", 5);
                put("June", 6);
                put("July", 7);
                put("August", 8);
                put("September", 9);
                put("October", 10);
                put("November", 11);
                put("December", 12);
            }
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String month = br.readLine();
        for (Map.Entry<String, Integer> entry:
             map.entrySet()) {
            if (entry.getKey().toLowerCase().equals(month.toLowerCase()))
                System.out.println(entry.getKey() + " is the " + entry.getValue() + " month");
        }
    }
}

