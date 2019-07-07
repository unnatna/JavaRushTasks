package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> children = new ArrayList<>();
        children.add(new Human("Vasya", 5, true));
        children.add(new Human("Vasilisa", 3, false));
        children.add(new Human("Vasgen", 1, true));

        Human father = new Human("Oleg", 35, true, children);
        Human mother = new Human("Olga", 33, false, children);

        Human grandfather1 = new Human("Ivan", 75, true, new ArrayList<Human>(){{add(father);}});
        Human grandmother1 = new Human("Marya", 68, false, new ArrayList<Human>(){{add(father);}});

        Human grandfather2 = new Human("Greg", 78, true, new ArrayList<Human>(){{add(mother);}});
        Human grandmother2 = new Human("Grechka", 69, false, new ArrayList<Human>(){{add(mother);}});

        System.out.println(grandfather1.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother2.toString());
        for (Human child:
             children) {
            System.out.println(child.toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();
        }

        Human(String name, int age, boolean sex, ArrayList<Human> children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
