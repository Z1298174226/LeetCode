package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/12/10.
 */
public class ConvertSortedArraytoBinarySearchTree {
    class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    public void convert(int[] array) {
        Node root = dfs(array, 0, array.length - 1);
        System.out.println(root);
    }

    private Node dfs(int[] array, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left)/ 2;
        Node root = new Node(array[mid]);
        Node leftNode = dfs(array, left, mid - 1);
        Node rightNode = dfs(array, mid + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-10,-3,0,5,9};
        new ConvertSortedArraytoBinarySearchTree().convert(array);
    }
}
