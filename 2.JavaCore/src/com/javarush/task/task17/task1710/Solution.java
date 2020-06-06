package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Person person;
        switch (args[0]) {
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " +
                        (person.getSex().equals(Sex.FEMALE) ? "ж" : "м") + " " +
                        (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate())));
                return;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                allPeople.set(Integer.parseInt(args[1]), person);
                return;
            case "-u":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex(args[3].equals("м")?Sex.MALE:Sex.FEMALE);
                try {
                    person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                allPeople.set(Integer.parseInt(args[1]), person);
                return;
            case "-c":
                try {
                    if (args[2].equals("м"))
                        person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                    else
                        person = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                    allPeople.add(person);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(allPeople.size() - 1);
                return;
        }
    }
}
