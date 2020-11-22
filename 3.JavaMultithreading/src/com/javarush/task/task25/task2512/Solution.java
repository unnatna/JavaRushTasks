package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printCause(e);
    }

    public static void main(String[] args) {
    }

    private void printCause(Throwable cause){
        if (cause.getCause() != null) {
            printCause(cause.getCause());
            System.out.println(cause);
        } else {
            System.out.println(cause);
        }
    }
}
