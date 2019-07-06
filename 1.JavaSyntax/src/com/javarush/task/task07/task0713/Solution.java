package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> source = new ArrayList<>();
        ArrayList<Integer> x3 = new ArrayList<>();
        ArrayList<Integer> x2 = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            source.add(Integer.parseInt(br.readLine()));
            int check = source.get(i);
            if (check % 3 == 0)
                x3.add(check);
            if (check % 2 == 0)
                x2.add(check);
            if ((check % 3 != 0) && (check % 2 != 0))
                other.add(check);
        }
        printList(x3);
        printList(x2);
        printList(other);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i: list) {
            System.out.println(i);
        }
    }
}
