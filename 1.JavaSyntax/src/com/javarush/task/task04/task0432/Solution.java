package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int iter = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String phrase = br.readLine();
        int count = Integer.parseInt(br.readLine());
        while (iter <= count) {
            System.out.println(phrase);
            iter++;
        }
    }
}
