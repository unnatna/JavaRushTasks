package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread target) {
        this.thread = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State current = thread.getState();
        System.out.println(current);
        while (true) {
            Thread.State state = thread.getState();
            if (state != current) {
                System.out.println(state);
                current = state;
            }
            if (current == State.TERMINATED) break;
        }

    }
}
