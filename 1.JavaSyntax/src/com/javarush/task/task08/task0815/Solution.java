package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванов00", "Иван");
        map.put("Иванов01", "Иваныч");
        map.put("Иванов02", "Иванчай");
        map.put("Иванов03", "Иван-Дурак");
        map.put("Иванов04", "Иван");
        map.put("Иванов05", "Иван");
        map.put("Иванов06", "Иван");
        map.put("Иванов07", "Иван");
        map.put("Иванов08", "Иван");
        map.put("Иванов09", "Иван");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int counter = 0;
        for (Map.Entry<String, String> entry:
             map.entrySet()) {
            if (entry.getValue().equals(name))
                counter++;
        }
        return counter;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        return map.containsKey(lastName) ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
