package main.java.com.utils;

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
}
