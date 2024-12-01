package main.java.com.algorithms.sorting;

import main.java.com.utils.ArrayUtils;

/**
 * Class for demonstrating the merge sort algorithm.
 */
public final class MergeSort {
    /**
     * Private constructor to prevent instantiation.
     */
    private MergeSort() {

    }

    /**
     * Main method for demonstrating the merge sort algorithm.
     * Initializes an array with random values, sorts it using merge sort,
     * and prints the time taken to sort the array.
     * 
     * @param args Command-line arguments, ignored.
     */
    public static void main(String[] args) {
        int[] arr = ArrayUtils.GetRandomArray(10000000, 10000, -10000);
        int j = arr.length - 1;
        // ArrayUtils.printArray(arr);
        sort(arr, 0, j);
        long startTime = System.nanoTime();
        sort(arr, 0, j);
        System.out
                .println("Time taken to sort the array by merge sort: " + (System.nanoTime() - startTime));

        // ArrayUtils.printArray(arr);
    }

    /**
     * Sorts an array using the merge sort algorithm.
     * 
     * Time Complexity:
     * Best Case: O(nlog(n)) when the array is already sorted.
     * Average Case: O(nlog(n))
     * Worst Case: O(nlog(n)) when the array is sorted in reverse order.
     * 
     * @param arr the array to be sorted
     * @param i   the start index of the array
     * @param j   the end index of the array
     */
    public static void sort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            sort(arr, i, mid);
            sort(arr, mid + 1, j);
            merge(arr, i, j, mid);
        }
    }

    /************* ✨ Codeium Command ⭐ *************/
    /**
     * Merges two sorted sub-arrays of the given array into a single sorted
     * sub-array.
     * 
     * @param arr the array to be merged
     * @param i   the start index of the array
     * @param j   the end index of the array
     * @param mid the middle index of the array
     */
    /****** 27f97795-1783-44f5-b3e9-eb2305ef9d6f *******/
    public static void merge(int[] arr, int i, int j, int mid) {
        // length arr1
        int l1 = mid - i + 1;
        // length arr2
        int l2 = j - mid;

        int[] arr1 = new int[l1];
        int[] arr2 = new int[l2];

        // populate the existing arr to these divided array
        for (int k = 0; k < l1; k++) {
            arr1[k] = arr[i + k];
        }

        for (int k = 0; k < l2; k++) {
            arr2[k] = arr[mid + 1 + k];
        }

        int p1 = 0, p2 = 0;
        int k = i;
        while (p1 < l1 && p2 < l2) {
            if (arr1[p1] <= arr2[p2]) {
                arr[k++] = arr1[p1++];
            } else {
                arr[k++] = arr2[p2++];
            }
        }

        // remaining elements
        while (p1 < l1) {
            arr[k++] = arr1[p1++];
        }
        while (p2 < l2) {
            arr[k++] = arr2[p2++];
        }
    }
}
