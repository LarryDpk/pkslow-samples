package com.pkslow.basic;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortingAlgorithmMain {
    public static void main(String[] args) {

        int[] randomIntsArray = genRandomIntsArray(20);
        System.out.println(Arrays.toString(randomIntsArray));
        bubbleSort(randomIntsArray);
        System.out.println(Arrays.toString(randomIntsArray));

        randomIntsArray = genRandomIntsArray(20);
        System.out.println(Arrays.toString(randomIntsArray));
        selectionSort(randomIntsArray);
        System.out.println(Arrays.toString(randomIntsArray));

        randomIntsArray = genRandomIntsArray(20);
        System.out.println(Arrays.toString(randomIntsArray));
        insertSort(randomIntsArray);
        System.out.println(Arrays.toString(randomIntsArray));

        randomIntsArray = genRandomIntsArray(20);
        System.out.println(Arrays.toString(randomIntsArray));
        shellSort(randomIntsArray);
        System.out.println(Arrays.toString(randomIntsArray));


    }

    private static int[] genRandomIntsArray(int count) {
        return IntStream.generate(() -> new Random().nextInt(100))
                .limit(count)
                .toArray();
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }

    private static int[] shellSort(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }
}