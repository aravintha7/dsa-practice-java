package main.java.com.utils;

import java.util.Random;

/**
 * Utility class for array operations
 */
public class ArrayUtils {

    /**
     * Private constructor to prevent instantiation
     */
    private ArrayUtils() {
    }

    /**
     * Swaps two elements in an array
     * 
     * @param arr    the array to modify
     * @param index1 the first index
     * @param index2 the second index
     */
    public static void swap(int[] arr, int index1, int index2) {
        // add and assign before subtraction
        arr[index1] = arr[index1] + arr[index2] - (arr[index2] = arr[index1]);
    }

    /**
     * Get array with specified size and with range in a random way
     * 
     * @param size   the array to modify
     * @param index1 the first index
     * @param index2 the second index
     */
    public static int[] GetRandomArray(int size, int high, int low) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(high - low) + low;
        }
        return arr;
    }

    /**
     * Prints the elements of an array to the console. The elements are printed in a
     * single line, separated by spaces.
     * 
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
