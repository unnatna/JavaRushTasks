package com.javarush.task.task14.task1419;

import java.io.ObjectStreamException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NoSuchMethodException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new SecurityException());
        exceptions.add(new UnsupportedOperationException());
        exceptions.add(new IllegalStateException());

    }
}
