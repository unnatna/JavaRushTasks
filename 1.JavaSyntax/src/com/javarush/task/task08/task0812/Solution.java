package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int count = 1;
        int max = 1;
        for (int i = 1; i < 10; i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                count++;
            }
            else {
                if (count > max)
                    max = count;
                count = 1;
            }
            if (count > max)
                max = count;
        }

        System.out.println(max);
    }
}
