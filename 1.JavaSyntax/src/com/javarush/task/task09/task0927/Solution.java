package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> catMap = new HashMap<>();
        catMap.put("Vaska", new Cat("Vaska"));
        catMap.put("Murzik", new Cat("Murzik"));
        catMap.put("Murka", new Cat("Murka"));
        catMap.put("Pushok", new Cat("Pushok"));
        catMap.put("Tishka", new Cat("Tishka"));
        catMap.put("Dasha", new Cat("Dasha"));
        catMap.put("Barsik", new Cat("Barsik"));
        catMap.put("Tom", new Cat("Tom"));
        catMap.put("Pussy", new Cat("Pussy"));
        catMap.put("Ryzhik", new Cat("Ryzhik"));
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> catSet = new HashSet<>();
        catSet.addAll(map.values());
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
