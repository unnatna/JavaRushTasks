package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top, left, height, width;
    public void initialize (int top, int left, int height, int width) {
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public void initialize (int top, int left) {
        this.top = top;
        this.left = left;
        this.height = 0;
        this.width = 0;
    }

    public void initialize (int top, int left, int height) {
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = height;
    }

    public void initialize () {
        this.top = 0;
        this.left = 0;
        this.height = 0;
        this.width = 0;
    }

    public static void main(String[] args) {

    }
}
