package org.example;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AppTest {

    // Helper function to check if an array is a valid permutation of another
    private boolean isPermutation(int[] original, int[] shuffled) {
        if (original.length != shuffled.length) return false;
        int[] originalSorted = Arrays.copyOf(original, original.length);
        int[] shuffledSorted = Arrays.copyOf(shuffled, shuffled.length);
        Arrays.sort(originalSorted);
        Arrays.sort(shuffledSorted);
        return Arrays.equals(originalSorted, shuffledSorted);
    }

    @Test
    void testNaiveShuffle() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(arr, arr.length);
        App.naiveShuffle(copy);
        assertTrue(isPermutation(arr, copy), "Naive shuffle should maintain a valid permutation");
    }

    @Test
    void testImprovedShuffle() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(arr, arr.length);
        App.improvedShuffle(copy);
        assertTrue(isPermutation(arr, copy), "Improved shuffle should maintain a valid permutation");
    }

    @Test
    void testFisherYatesShuffle() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(arr, arr.length);
        App.fisherYatesShuffle(copy);
        assertTrue(isPermutation(arr, copy), "Fisher-Yates shuffle should maintain a valid permutation");
    }

    @Test
    void testDifferentArraySizes() {
        int[] sizes = {10, 100, 1000};
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = i + 1;

            int[] copy = Arrays.copyOf(arr, arr.length);
            App.fisherYatesShuffle(copy);
            assertTrue(isPermutation(arr, copy), "Shuffle should maintain a valid permutation for size " + size);
        }
    }
}
