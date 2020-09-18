package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Person person;

        //System.out.println(args.length);
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length / 3; i++) {
                        try {
                            if (args[3 * i - 1].equals("м")) {
                                person = Person.createMale(args[3 * i - 2], new SimpleDateFormat("dd/MM/yyyy").parse(args[3 * i]));
                            }
                            else {
                                person = Person.createFemale(args[3 * i - 2], new SimpleDateFormat("dd/MM/yyyy").parse(args[3 * i]));
                            }
                            allPeople.add(person);
                            System.out.println(allPeople.size() - 1);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length / 4; i++) {
                        person = allPeople.get(Integer.parseInt(args[i * 4 - 3]));
                        person.setName(args[i * 4 - 2]);
                        person.setSex(args[i * 4 - 1].equals("м") ? Sex.MALE : Sex.FEMALE);
                        try {
                            person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[i * 4]));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        allPeople.set(Integer.parseInt(args[i * 4 - 3]), person);
                    }
                }
                return;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                    }
                }
                return;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " +
                                (person.getSex().equals(Sex.FEMALE) ? "ж" : "м") + " " +
                                (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate())));
                    }
                }
                return;

        }

    }
}
