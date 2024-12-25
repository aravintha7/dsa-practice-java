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
        // sort(arr, 0, j);
        long startTime = System.nanoTime();
        sort(arr, 0, j);
        System.out
                .println("Time taken to sort the array by merge sort: " + (System.nanoTime()
                        - startTime));

        // ArrayUtils.printArray(arr);
    }

    public static void sort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            sort(arr, i, mid);
            sort(arr, mid + 1, j);
            conquer(arr, i, mid, j);
        }
    }

    public static void conquer(int[] arr, int i, int mid, int j) {
        int n1 = mid - i + 1;
        int n2 = j - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        int p1 = 0, p2 = i;
        while (p1 < n1) {
            arr1[p1++] = arr[p2++];
        }

        p1 = 0;
        p2 = mid + 1;
        while (p1 < n2) {
            arr2[p1++] = arr[p2++];
        }

        // merge the both array into the given array
        int k = i, l = 0, m = 0;
        while (l < n1 && m < n2) {
            if (arr1[l] <= arr2[m]) {
                arr[k++] = arr1[l++];
            } else {
                arr[k++] = arr2[m++];
            }
        }

        while (l < n1) {
            arr[k++] = arr1[l++];
        }
        while (m < n2) {
            arr[k++] = arr2[m++];
        }
    }
}
