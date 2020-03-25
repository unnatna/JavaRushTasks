package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread spec1 = new SpecialThread();
        SpecialThread spec2 = new SpecialThread();
        SpecialThread spec3 = new SpecialThread();
        SpecialThread spec4 = new SpecialThread();
        SpecialThread spec5 = new SpecialThread();
        Thread thread1 = new Thread(spec1);
        Thread thread2 = new Thread(spec2);
        Thread thread3 = new Thread(spec3);
        Thread thread4 = new Thread(spec4);
        Thread thread5 = new Thread(spec5);
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
