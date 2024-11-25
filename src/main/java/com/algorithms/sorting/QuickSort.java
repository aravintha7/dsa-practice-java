package main.java.com.algorithms.sorting;

import main.java.com.Constant;
import main.java.com.utils.ArrayUtils;

/**
 * Class for demonstrating the quick sort algorithm.
 */
public class QuickSort {

    /**
     * Private constructor to prevent instantiation.
     */
    private QuickSort() {

    }

    /**
     * Main method for demonstrating the quick sort algorithm.
     * Initializes an array with random values, prints the unsorted array,
     * sorts it using quick sort, and prints the sorted array.
     * 
     * @param args Command-line arguments, ignored.
     */
    public static void main(String[] args) {
        // System.out.println("Unsorted array: ");
        // ArrayUtils.printArray(arr);

        int[] arr1 = ArrayUtils.GetRandomArray(10000000, 10000, -10000);
        long startTime = System.nanoTime();
        sort(arr1, Constant.THREE_MEDIAN_PARTITIONS);
        System.out
                .println("Time taken to sort the array by three median partitions: " + (System.nanoTime() - startTime));

        int[] arr2 = ArrayUtils.GetRandomArray(10000000, 10000, -10000);
        startTime = System.nanoTime();
        sort(arr2, Constant.PIVOT_AT_START);
        System.out.println("Time taken to sort the array by pivot at start: " + (System.nanoTime() - startTime));

        int[] arr3 = ArrayUtils.GetRandomArray(10000000, 10000, -10000);
        startTime = System.nanoTime();
        sort(arr3, Constant.PIVOT_AT_END);
        System.out.println("Time taken to sort the array by pivot at end: " + (System.nanoTime() - startTime));

        // System.out.println("\nSorted array: ");
        // ArrayUtils.printArray(arr);
    }

    public static void sort(int[] arr, String type) {
        if (type == null) {
            type = Constant.THREE_MEDIAN_PARTITIONS;
        }
        switch (type) {
            case Constant.PIVOT_AT_START:
                SortByPivotAtStart(arr, 0, arr.length - 1);
                break;
            case Constant.PIVOT_AT_END:
                SortByPivotAtEnd(arr, 0, arr.length - 1);
                break;
            case Constant.THREE_MEDIAN_PARTITIONS:
            default:
                SortByPivotWithThreeMedians(arr, 0, arr.length - 1);
                break;
        }
    }

    /**
     * Sorts an array using the quick sort algorithm with three median partitions.
     * The three median partitions are the median of the first, middle, and last
     * elements of the array. The function partitions the array around the median
     * of the three medians, and recursively calls itself on the two partitions
     * that are formed.
     * 
     * Time Complexity:
     * Best Case: O(nlog(n)) when the array is already sorted.
     * Average Case: O(nlog(n))
     * Worst Case: O(n^2) when the array is sorted in reverse order.
     * 
     * @param arr   the array to be sorted
     * @param start the start index of the array
     * @param end   the end index of the array
     */
    private static void SortByPivotWithThreeMedians(int[] arr, int start, int end) {
        if (start < end) {
            int[] medianPartition = PartitionByThreeMedians(arr, start, end);
            SortByPivotWithThreeMedians(arr, start, medianPartition[0] - 1);
            SortByPivotWithThreeMedians(arr, medianPartition[1] + 1, end);
        }
    }

    /**
     * Partitions the array around the median of the first, middle, and last
     * elements. The function iterates from the left of the array towards the
     * right, and swaps an element with the partition index if the element is
     * less than the median. After iteration, the median element is swapped with
     * the element at the partition index. The partition index is returned.
     * 
     * @param arr   the array to be partitioned
     * @param start the start index of the array
     * @param end   the end index of the array
     * @return the index of the median element after partitioning
     */
    private static int[] PartitionByThreeMedians(int[] arr, int start, int end) {
        int lt = start, eq = start, gt = end;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        while (eq <= gt) {
            if (arr[eq] < pivot) {
                ArrayUtils.swap(arr, eq, lt);
                lt++;
                eq++;
            } else if (arr[eq] > pivot) {
                ArrayUtils.swap(arr, eq, gt);
                gt--;
            } else {
                eq++;
            }
        }
        return new int[] { lt, gt };
    }

    /**
     * Sorts an array using the quick sort algorithm.
     * 
     * Time Complexity:
     * Best Case: O(nlog(n)) when the array is already sorted.
     * Average Case: O(nlog(n))
     * Worst Case: O(n^2) when the array is sorted in reverse order.
     * 
     * @param arr   the array to be sorted
     * @param start the start index of the array
     * @param end   the end index of the array
     */
    private static void SortByPivotAtEnd(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partitionByPivotAtEnd(arr, start, end);
            SortByPivotAtEnd(arr, start, partitionIndex - 1);
            SortByPivotAtEnd(arr, partitionIndex + 1, end);
        }
    }

    /**
     * Sorts an array using the quick sort algorithm.
     * 
     * Time Complexity:
     * Best Case: O(nlog(n)) when the array is already sorted.
     * Average Case: O(nlog(n))
     * Worst Case: O(n^2) when the array is sorted in reverse order.
     * 
     * @param arr   the array to be sorted
     * @param start the start index of the array
     * @param end   the end index of the array
     */
    private static void SortByPivotAtStart(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partitionByPivotAtStart(arr, start, end);
            SortByPivotAtStart(arr, start, partitionIndex - 1);
            SortByPivotAtStart(arr, partitionIndex + 1, end);
        }
    }

    /**
     * Partitions the array around a pivot element. The pivot element is chosen as
     * the
     * first element of the array. The function iterates from the right of the array
     * towards the left, and swaps an element with the partition index if the
     * element
     * is greater than the pivot element. After iteration, the pivot element is
     * swapped
     * with the element at the partition index. The partition index is returned.
     * 
     * @param arr   the array to be partitioned
     * @param start the start index of the array
     * @param end   the end index of the array
     * @return the index of the pivot element after partitioning
     */

    private static int partitionByPivotAtStart(int[] arr, int start, int end) {
        int pivot = arr[start];
        int partitionIndex = end;
        for (int i = end; i > start; i--) {
            if (arr[i] > pivot) {
                ArrayUtils.swap(arr, partitionIndex, i);
                partitionIndex--;
            }
        }
        ArrayUtils.swap(arr, partitionIndex, start);
        return partitionIndex;
    }

    /**
     * Partitions the array around a pivot element. The pivot element is chosen as
     * the last element of the array. The function iterates from the left of the
     * array towards the right, and swaps an element with the partition index if
     * the element is less than the pivot element. After iteration, the pivot
     * element is swapped with the element at the partition index. The partition
     * index is returned.
     * 
     * @param arr   the array to be partitioned
     * @param start the start index of the array
     * @param end   the end index of the array
     * @return the index of the pivot element after partitioning
     */
    private static int partitionByPivotAtEnd(int[] arr, int start, int end) {
        int pivot = arr[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                ArrayUtils.swap(arr, partitionIndex, i);
                partitionIndex++;
            }
        }
        ArrayUtils.swap(arr, partitionIndex, end);
        return partitionIndex;
    }
}
