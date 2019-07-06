package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Макаров", "Евгений");
        map.put("Петросян", "Сильвестр");
        map.put("Шварцнейгер", "Арнольд");
        map.put("Собчак", "Владимир");
        map.put("Собчак", "Ксения");
        map.put("Петросян", "Евгений");
        map.put("Бородина", "Ксения");
        map.put("Навальный", "Алексей");
        map.put("Петросян", "Оскар");
        map.put("Гришковец", "Евгений");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
