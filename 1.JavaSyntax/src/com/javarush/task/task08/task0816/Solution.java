package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        map.put("Алькапоне", dateFormat.parse("JUN 1 2012"));
        map.put("Джованни", dateFormat.parse("MAY 1 2012"));
        map.put("Родригес", dateFormat.parse("JUL 1 2012"));
        map.put("Маркус", dateFormat.parse("MAY 1 2012"));
        map.put("Марчелло", dateFormat.parse("AUG 1 2012"));
        map.put("Чичолина", dateFormat.parse("MAY 1 2012"));
        map.put("Чичерина", dateFormat.parse("MAY 1 2012"));
        map.put("Капулетти", dateFormat.parse("MAY 1 2012"));
        map.put("Монтекки", dateFormat.parse("MAY 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
            Date date = iterator.next().getValue();
            if (Integer.parseInt(dateFormat.format(date)) > 5 &&
                    Integer.parseInt(dateFormat.format(date)) < 9)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
