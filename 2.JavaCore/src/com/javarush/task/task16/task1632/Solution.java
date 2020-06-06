package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new Loop()));
        threads.add(new IntExc());
        threads.add(new Thread(new Hura()));
        threads.add(new Clock());
        threads.add(new Thread(new SumInts()));
    }

    public static void main(String[] args) {

    }
}

class Loop implements Runnable {
    @Override
    public void run() {
        while (true) {
        }
    }
}

class IntExc extends Thread {
    @Override
    public void run() {
        if (isInterrupted())
            System.out.println("InterruptedException");
    }
}

class Hura implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Clock extends Thread implements Message {
    private boolean isAlive = true;

    public void cancel() {
        isAlive = false;
    }

    @Override
    public void run() {
        while (isAlive) {

        }
    }

    @Override
    public void showWarning() {
        this.cancel();
    }
}

class SumInts implements Runnable {
    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        while (true) {
            try {
                String value = bufferedReader.readLine();
                if (value.equals("N")) {
                    System.out.println(result);
                    break;
                }
                result += Integer.parseInt(value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}