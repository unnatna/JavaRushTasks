package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public void run() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse:
             getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse:
             getHorses()) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int maxDistance = 0;
        Horse winner = null;
        for (Horse horse:
             getHorses()) {
            if (horse.getDistance() > maxDistance) {
                winner = horse;
                maxDistance = (int) Math.floor(horse.getDistance());
            }
        }
        return winner;
    }

    public void printWinner() {
        Horse winner = getWinner();
        System.out.printf("Winner is %s!", winner.getName());
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Iskra", 3, 0));
        game.getHorses().add(new Horse("BlackStar", 3, 0));
        game.getHorses().add(new Horse("Plotva", 3, 0));

        try {
            game.run();
            game.printWinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
