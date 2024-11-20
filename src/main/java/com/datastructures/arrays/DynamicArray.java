package main.java.com.datastructures.arrays;

public class DynamicArray {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 5, 5, 5, 5 };
        DynamicArray dArray = new DynamicArray();
        System.out.println("Element occur more than n/2: " + dArray.elementMoreThanHalf(arr));
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
}
