package com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton instance;
    private static int instanceCount = 0;

    private Singleton() {
        instanceCount++;
    }

    public static Singleton getInstance() {
        if (instanceCount == 0)
            instance = new Singleton();
        return instance;
    }
}
