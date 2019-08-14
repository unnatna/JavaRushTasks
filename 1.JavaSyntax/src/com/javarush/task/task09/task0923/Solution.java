package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        List<Character> vowelsLst = new ArrayList<>();
        List<Character> notVowelsLst = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i]))
                vowelsLst.add(chars[i]);
            else if (chars[i] != ' ')
                notVowelsLst.add(chars[i]);
        }

        for (Character ch:
             vowelsLst) {
            System.out.print(ch);
            System.out.print(" ");
        }

        System.out.println();

        for (Character ch:
             notVowelsLst) {
            System.out.print(ch);
            System.out.print(" ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}