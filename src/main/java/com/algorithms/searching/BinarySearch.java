package main.java.com.algorithms.searching;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 19 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to search: ");
        int element = sc.nextInt();
        int position = binarySearch(arr, element);

        if (position != -1) {
            System.out.println("The element exists! and its position is " + position);
        } else {
            System.out.println("The element doesn't exists");
        }
    }

    public static int binarySearch(int[] arr, int element) {
        return binarySearch(arr, element, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int element, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == element) {
            return mid;
        } else if (arr[mid] > element) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return binarySearch(arr, element, start, end);
    }

}
