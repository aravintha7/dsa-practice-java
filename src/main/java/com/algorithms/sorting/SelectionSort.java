package main.java.com.algorithms.sorting;

import main.java.com.utils.ArrayUtils;

/**
 * Class for demonstrating the selection sort algorithm.
 */
public class SelectionSort {

    /**
     * Private constructor to prevent instantiation.
     */
    private SelectionSort() {

    }

    /**
     * Main method for demonstrating the selection sort algorithm.
     * Initializes an array, sorts it using selection sort, and prints the sorted
     * array.
     * 
     * @param args Command-line arguments, ignored.
     */
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1, 1, 2, 3 };
        arr = selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * Sorts an array using the selection sort algorithm.
     * 
     * Time Complexity:
     * Best Case: O(n^2) when the array is already sorted.
     * Average Case: O(n^2)
     * Worst Case: O(n^2) when the array is sorted in reverse order.
     * 
     * @param arr the array to be sorted
     */
    public static int[] selectionSort(int[] arr) {
        int minIdx;
        for (int i = 0; i < arr.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                ArrayUtils.swap(arr, i, minIdx);
            }
        }
        return arr;
    }
}
