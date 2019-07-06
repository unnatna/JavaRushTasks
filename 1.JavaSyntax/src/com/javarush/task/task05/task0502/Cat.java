package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int winner = 0;

        if (this.age > anotherCat.age)
            winner++;
        else winner--;

        if (this.weight > anotherCat.weight)
            winner++;
        else winner--;

        if (this.strength > anotherCat.strength)
            winner++;
        else winner--;

        if (winner > 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}
