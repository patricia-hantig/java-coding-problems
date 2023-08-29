package com.patri.StringArrayManipulation;

public class SecondHighestNumberExtractor {

    public static int getSecondHighestNumber(int[] array) {
        int biggest, secondBiggest;
        if (array[0] > array[1]) {
            biggest = array[0];
            secondBiggest = array[1];
        } else {
            secondBiggest = array[0];
            biggest = array[1];
        }

        for (int i = 2; i < array.length; i++) {
            if (biggest < array[i]) {
                secondBiggest = biggest;
                biggest = array[i];
            } else if (secondBiggest < array[i]) {
                secondBiggest = array[i];
            }
        }
        return secondBiggest;
    }

    public static void main(String[] args) {
        System.out.println(getSecondHighestNumber(new int[]{30, 150, 15, 2, 8, 80}));
        System.out.println(getSecondHighestNumber(new int[]{30, 150, 15, 2, 8}));
        System.out.println(getSecondHighestNumber(new int[]{30, 150, 15, 2, 8, 800}));
        System.out.println(getSecondHighestNumber(new int[]{30, 150, 15, 2, 8, 800, 800}));
        System.out.println(getSecondHighestNumber(new int[]{-30, -150, -15, -2, -8, -800}));
        System.out.println(getSecondHighestNumber(new int[]{30, 150}));
        System.out.println(getSecondHighestNumber(new int[]{30}));
    }
}
