package com.javarush.task.task21.task2101;

import java.util.Arrays;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[ip.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (ip[i] & mask[i]);
        }
        return result;
    }

    public static void print(byte[] bytes) {
        for (byte b:
             bytes) {
            System.out.print(
                    String.format("%32s", Integer.toBinaryString(b)).replace(" ", "0").substring(24, 32) + " ");
        }
        System.out.println();
    }
}
