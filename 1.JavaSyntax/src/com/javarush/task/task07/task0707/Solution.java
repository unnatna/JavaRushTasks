package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add("Qwerty1");
        list.add("Qwerty2");
        list.add("Qwerty3");
        list.add("Qwerty4");
        list.add("Qwerty5");
        System.out.println(list.size());
        for (String s: list) {
            System.out.println(s);
        }
    }
}
