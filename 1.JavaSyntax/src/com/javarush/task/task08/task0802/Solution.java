package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String, String> pairs = new HashMap<>();
        pairs.put("арбуз", "ягода");
        pairs.put("банан", "трава");
        pairs.put("вишня", "ягода");
        pairs.put("груша", "фрукт");
        pairs.put("дыня", "овощ");
        pairs.put("ежевика", "куст");
        pairs.put("жень-шень", "корень");
        pairs.put("земляника", "ягода");
        pairs.put("ирис", "цветок");
        pairs.put("картофель", "клубень");
        for (Map.Entry<String, String> entry:
             pairs.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
