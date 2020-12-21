package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        boolean isBelowZero = number < 0;

        StringBuilder sb = new StringBuilder(String.valueOf(number));
        sb.append(" = ");

        int x = 0;
        while (number > 0) {
            int a = number % 3;
            number = number / 3;
            switch (a) {
                case 1:
                    sb.append(" + ").append((int) Math.pow(3, x));
                    break;
                case 2:
                    number += 1;
                    sb.append(" - ").append((int) Math.pow(3, x));
                    break;
            }
            x++;
        }
        if (isBelowZero) {
            sb.toString().replace('+', '$').replace('-', '+').replace('$', '-');
        }
        System.out.println(sb.toString());

    }
}