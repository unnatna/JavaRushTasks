package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0, "One");
        labels.put(10.0, "Two");
        labels.put(15.0, "Three");
        labels.put(178.0, "Four");
        labels.put(1457.0, "Five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
