package main.java.com.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.algorithms.sorting.QuickSort;
import main.java.com.utils.ArrayUtils;

public class DynamicArray {
    public static void main(String[] args) {
        DynamicArray dArray = new DynamicArray();
        // int[] arr = { 3, 3, 3, 5, 5, 5, 5, 1 };

        // System.out.println("Element occur more than n/2: " +
        // dArray.elementMoreThanHalf(arr));
        int[] arr = { 0, 3, 0, 5, 1, 0, 0, 4 };

        // System.out.println("The duplicates are " + dArray.findDuplicates(arr));
        // QuickSort.sort(arr, null);
        // int unique = dArray.uniqueElements(arr);
        // System.out.println("The unique elements in the array " + unique);
        // System.out.println("The array after removing the duplicates ");
        // ArrayUtils.printArray(arr, unique);

        System.out.println("Pushing zeros to the end...");
        dArray.pushZerosToEnd(arr);
        ArrayUtils.printArray(arr);
    }

    /**
     * Finds the element in the array that occurs more than n/2 times. Uses the
     * Boyer-Moore Voting Algorithm. The algorithm works by essentially
     * maintaining a counter for the majority element. If the counter is 0, the
     * algorithm sets the current candidate for majority element to the current
     * element. If the counter is not 0, the algorithm increments or decrements
     * the counter based on whether the current element matches the candidate for
     * majority element or not. After going through all the elements, the
     * candidate for majority element is the element that occurs more than n/2.
     * 
     * @param arr the array to check
     * @return the element that occurs more than n/2 times
     */
    public int elementMoreThanHalf(int[] arr) {
        if (arr.length < 3)
            return arr[0];
        int item = arr[0];
        int vote = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == item) {
                // if the current element matches the candidate, increment the
                // counter
                vote++;
            } else {
                // if the current element does not match the candidate, decrement
                // the counter
                vote--;
            }
            if (vote == 0) {
                // if the counter is 0, set the current candidate to the current
                // element
                item = arr[i];
                vote = 1;
            }
        }
        return item;
    }

    /**
     * Finds and returns a list of duplicate elements in the given array.
     * The method modifies the input array to keep track of the frequency
     * of each element by using the element values as indices. If an element
     * appears more than once, its index is added to the result list.
     * If no duplicates are found, the result list contains -1.
     * 
     * @param arr the array to check for duplicates
     * @return a list of indices of duplicate elements, or -1 if no duplicates
     */
    public List<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    /************* ✨ Codeium Command ⭐ *************/
    /**
     * Removes duplicates from the array in-place and returns the number of
     * unique elements. The algorithm works by maintaining two pointers, i and
     * j. The i pointer is used to keep track of the unique elements while the j
     * pointer is used to traverse the array. If the elements at i and j are the
     * same, j is incremented. If the elements at i and j are not the same, the
     * element at j is swapped with the element at i+1 and then j is incremented.
     * This process continues until j reaches the end of the array. The number of
     * unique elements is given by i+1.
     * 
     * This optimization reduces the number of swaps required when the input array
     * has no duplicates or has a small number of duplicates. In the worst-case
     * scenario where the array has no duplicates, this optimization eliminates the
     * need for swapping altogether, resulting in a more efficient algorithm.
     * 
     * @param arr the array to remove duplicates from
     * @return the number of unique elements in the array
     */
    /****** a2de3731-cc25-4b35-a285-7850b8832647 *******/
    public int uniqueElements(int[] arr) {
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else if (i + 1 != j) {
                // optimization where if the elements at indices i and j are not equal and not
                // adjacent (i + 1 != j), then it swaps the elements at indices i+1 and j.
                ArrayUtils.swap(arr, ++i, j++);
            } else {
                // But if the elements at indices i and j are adjacent (i + 1 == j), then it
                // simply increments both i and j without swapping.
                j++;
                i++;
            }
        }
        return i + 1;
    }

    void pushZerosToEnd(int[] arr) {
        // code here
        int ptr = 0, itr = 0;
        while (itr < arr.length) {
            if (arr[itr] != 0) {
                if (itr != ptr) {
                    ArrayUtils.swap(arr, ptr, itr);
                }
                itr++;
                ptr++;
            } else {
                itr++;
            }
        }
    }
}
