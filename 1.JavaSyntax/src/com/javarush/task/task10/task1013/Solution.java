package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        String firstName = "Unknown";
        String secondName = "Unknown";
        int age = 0;
        char sex = 'm';
        boolean isDriver = false;
        ArrayList<Human> children;

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String secondName, int age, char sex, boolean isDriver, ArrayList<Human> children) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
            this.isDriver = isDriver;
            this.children = children;
        }

        public Human(String firstName, String secondName, char sex, ArrayList<Human> children) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.sex = sex;
            this.children = children;
        }

        public Human(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public Human(String firstName, String secondName, boolean isDriver) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.isDriver = isDriver;
        }

        public Human(String firstName, String secondName, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String firstName, String secondName, int age, char sex) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, char sex) {
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String secondName, ArrayList<Human> children) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.children = children;
        }

        public Human(int age, char sex, boolean isDriver) {
            this.age = age;
            this.sex = sex;
            this.isDriver = isDriver;
        }
    }
}
