package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bf.readLine());
        String name = bf.readLine();
        System.out.println(name + " захватит мир через " + year + " лет. Му-ха-ха!");
    }
}
