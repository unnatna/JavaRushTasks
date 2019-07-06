package com.javarush.task.task08.task0814;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        return new HashSet<Integer>(Arrays.asList(new Integer[] {1, 2, 4, 11, 12, 5, 16, 0, 7, 8, 1, 2, 4, 11, 12, 5, 16, 0, 7, 8}));
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Set result = new HashSet<Integer>();
        set.forEach(integer -> {if (integer <= 10) result.add(integer);});
        return result;
    }

    public static void main(String[] args) {

    }
}
