package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandpa1 = new Human("Ivan", true, 77);
        Human grandpa2 = new Human("Vovan", true, 77);
        Human grandma1 = new Human("Olya", false, 75);
        Human grandma2 = new Human("Luba", false, 75);
        Human father = new Human("Oleg", true, 55, grandpa1, grandma1);
        Human mother = new Human("Luda", false, 45, grandpa2, grandma2);
        Human son = new Human("Vlad", true, 15, father, mother);
        Human douther = new Human("Lena", false, 12, father, mother);

        System.out.println(grandpa1);
        System.out.println(grandma1);
        System.out.println(grandpa2);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(douther);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}