package main.java.com.algorithms.randomproblems;

import java.util.Scanner;

import main.java.com.datastructures.trees.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        if (boxFitInTile(a, b, x, y)) {
            System.out.println("Escape is possible.");
        } else {
            System.out.println("Box cannot be dropped.");
        }
    }

    /*
     * You are given a string s and an integer repeatLimit. Construct a new string
     * repeatLimitedString using the characters of s such that no letter appears
     * more than repeatLimit times in a row. You do not have to use all characters
     * from s.
     * 
     * Return the lexicographically largest repeatLimitedString possible.
     * 
     * A string a is lexicographically larger than a string b if in the first
     * position where a and b differ, string a has a letter that appears later in
     * the alphabet than the corresponding letter in b. If the first min(a.length,
     * b.length) characters do not differ, then the longer string is the
     * lexicographically larger one.
     * 
     * Example 1:
     * Input: s = "cczazcc", repeatLimit = 3
     * Output: "zzcccac"
     * Explanation: We use all of the characters from s to construct the
     * repeatLimitedString "zzcccac".
     * The letter 'a' appears at most 1 time in a row.
     * The letter 'c' appears at most 3 times in a row.
     * The letter 'z' appears at most 2 times in a row.
     * Hence, no letter appears more than repeatLimit times in a row and the string
     * is a valid repeatLimitedString.
     * The string is the lexicographically largest repeatLimitedString possible so
     * we return "zzcccac".
     * Note that the string "zzcccca" is lexicographically larger but the letter 'c'
     * appears more than 3 times in a row, so it is not a valid repeatLimitedString.
     * 
     * Example 2:
     * Input: s = "aababab", repeatLimit = 2
     * Output: "bbabaa"
     * Explanation: We use only some of the characters from s to construct the
     * repeatLimitedString "bbabaa".
     * The letter 'a' appears at most 2 times in a row.
     * The letter 'b' appears at most 2 times in a row.
     * Hence, no letter appears more than repeatLimit times in a row and the string
     * is a valid repeatLimitedString.
     * The string is the lexicographically largest repeatLimitedString possible so
     * we return "bbabaa".
     * Note that the string "bbabaaa" is lexicographically larger but the letter 'a'
     * appears more than 2 times in a row, so it is not a valid repeatLimitedString.
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (bucket[i] == 0)
                continue;
            int ctr = 0;
            while (bucket[i] > 0) {
                if (ctr == repeatLimit) {
                    int nextLargeChar = getNxtLargeChar(bucket, i);
                    if (nextLargeChar >= 0) {
                        sb.append((char) ('a' + nextLargeChar));
                        bucket[nextLargeChar]--;
                        ctr = 0;
                    } else {
                        break;
                    }
                } else {
                    sb.append((char) ('a' + i));
                    bucket[i]--;
                    ctr++;
                }
            }
        }
        return sb.toString();
    }

    private static int getNxtLargeChar(int[] bucket, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (bucket[j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /*
     * 
     */
    public static boolean boxFitInTile(int a, int b, int x, int y) {
        if ((x < a && y < b) || (x < b && y < a)) {
            return true;
        }
        return false;
    }

    public static boolean isTreeSquare(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if ((long) p.val * p.val != q.val && (long) q.val * q.val != p.val)
            return false;
        return isTreeSquare(p.left, q.left) && isTreeSquare(p.right, q.right);
    }
}
