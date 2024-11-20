package main.java.com.algorithms.sorting;

import main.java.com.utils.ArrayUtils;

public class BubbleSort {
    /**
     * Main method for demonstrating the bubble sort algorithm.
     * @param args Command-line arguments, ignored.
     */
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Sorts an array using the bubble sort algorithm.
     * 
     * Time Complexity:
     * Best Case: O(n) when the array is already sorted.
     * Average Case: O(n^2) due to nested loops.
     * Worst Case: O(n^2) when the array is sorted in reverse order.
     *
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1 ; i++){
            for(int j = 0; j < arr.length - 1 - i ; j++){
                ArrayUtils.swap(arr, j, j+1);
            }
        }
    }
}
