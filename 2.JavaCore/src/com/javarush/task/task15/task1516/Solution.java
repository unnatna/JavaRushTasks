package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar = 1;
    public double doubleVar = 1.0;
    public Double DoubleVar = 2D;
    public boolean booleanVar = false;
    public Object ObjectVar = null;
    public Exception ExceptionVar = null;
    public String StringVar = "Java";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intVar + " "  + solution.doubleVar +  " "  + solution.DoubleVar +  " "  +
                solution.booleanVar +  " "  + solution.ObjectVar +  " "  + solution.ExceptionVar +  " "  +
                solution.StringVar);
    }
}
