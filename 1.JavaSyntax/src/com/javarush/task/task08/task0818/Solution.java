package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Макаров", 500);
        map.put("Сталлоне", 250);
        map.put("Шварцнейгер", 100);
        map.put("Путин", 650);
        map.put("Собчак", 1500);
        map.put("Петросян", 1400);
        map.put("Бородина", 290);
        map.put("Навальный", 110);
        map.put("ДеЛаХойя", 500);
        map.put("Гришковец", 600);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}