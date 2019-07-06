package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Макаров", "Евгений");
        map.put("Сталлоне", "Сильвестр");
        map.put("Шварцнейгер", "Арнольд");
        map.put("Путин", "Владимир");
        map.put("Собчак", "Ксения");
        map.put("Петросян", "Евгений");
        map.put("Бородина", "Ксения");
        map.put("Навальный", "Алексей");
        map.put("ДеЛаХойя", "Оскар");
        map.put("Гришковец", "Евгений");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> aList = new ArrayList<>(map.values());

        for (String s:
             aList) {
            if (Collections.frequency(aList, s) > 1)
                removeItemFromMapByValue(map, s);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
