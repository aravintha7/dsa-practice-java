package main.java.com.algorithms.randomproblems;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left;
    TreeNode middle;
    TreeNode right;
    int value;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }
}

public class TripletTree {

    TreeNode makeTripletTree(int[] x) {
        if (x.length == 0) {
            return null;
        }
        if (x.length == 1) {
            return new TreeNode(x[0]);
        }
        TreeNode treeNode = new TreeNode(x[0]);
        TreeNode root = treeNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int currentIndex = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (currentIndex < x.length) {
                current.left = new TreeNode(x[currentIndex++]);
                queue.add(current.left);
            }
            if (currentIndex < x.length) {
                current.middle = new TreeNode(x[currentIndex++]);
                queue.add(current.middle);
            }
            if (currentIndex < x.length) {
                current.right = new TreeNode(x[currentIndex++]);
                queue.add(current.right);
            }
        }
        return root;
    }

    public static void print(TreeNode treeNode) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        queue.add(null);
        System.out.println(treeNode.value);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.println();
            }
            if (node != null) {
                if (node.left != null) {
                    queue.add(node.left);
                    System.out.print(node.left.value + "(" + node.value + ")" + "   ");
                }
                if (node.middle != null) {
                    queue.add(node.middle);
                    System.out.print(node.middle.value + "(" + node.value + ")" + "   ");
                }
                if (node.right != null) {
                    queue.add(node.right);
                    System.out.print(node.right.value + "(" + node.value + ")" + "   ");
                }
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("test!");

        TreeNode root = new TripletTree().makeTripletTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 });
        print(root);

    }
}