package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date formDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        try {
            formDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(formDate);
        return cal.get(Calendar.DAY_OF_YEAR) % 2 == 0?false:true;
    }
}
