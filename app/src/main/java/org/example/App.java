package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {

    public static void naiveShuffle(int[] arr) {
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[n];
        Random rand = new Random();

        while (temp.size() < n) {
            int index = rand.nextInt(n);
            if (!used[index]) {
                temp.add(arr[index]);
                used[index] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp.get(i);
        }
    }

    public static void improvedShuffle(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void fisherYatesShuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000};
        int trials = 4;

        for (int size : sizes) {
            System.out.println("Array size: " + size);
            for (int t = 0; t < trials; t++) {
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) arr[i] = i + 1;

                int[] tempArr = Arrays.copyOf(arr, arr.length);
                System.out.print("  Naive Shuffle: ");
                naiveShuffle(tempArr);
                System.out.println(Arrays.toString(tempArr));

                tempArr = Arrays.copyOf(arr, arr.length);
                System.out.print("  Improved Shuffle: ");
                improvedShuffle(tempArr);
                System.out.println(Arrays.toString(tempArr));

                tempArr = Arrays.copyOf(arr, arr.length);
                System.out.print("  Fisher-Yates Shuffle: ");
                fisherYatesShuffle(tempArr);
                System.out.println(Arrays.toString(tempArr));
            }
        }
    }
}
