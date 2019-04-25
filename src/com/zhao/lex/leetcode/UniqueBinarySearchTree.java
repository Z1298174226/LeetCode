package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qtfs on 2019/4/18.
 */
public class UniqueBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode left;
        TreeNode right;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if(this == null) return builder.toString();
            else {
                Stack<TreeNode> stack = new Stack<TreeNode>();
                TreeNode currentNode = this;
                while(currentNode != null || !stack.isEmpty()) {
                    while(currentNode != null) {
                        builder.append(Integer.valueOf(currentNode.val));
                        stack.add(currentNode);
                        currentNode = currentNode.left;
                    }
                    if(!stack.isEmpty()) {
                        TreeNode node = stack.pop();
                        currentNode = node.right;
                    }
                }
            }
            return builder.toString();
        }
    }
    public int count = 0;

    public int numTrees(int n) {
        if(n == 0) return 0;
        numTrees(1, n);
        return count;
    }

    private void numTrees(int start, int end) {
        if(start > end) return;
        if(start == end) {
            count++;
            return;
        }
        for(int i = start + 1; i <= end; i++) {
            numTrees(start, i - 1);
            numTrees(i + 1, end);
        }

    }

    public List<TreeNode> uniqueBinarySearch(int n) {
        return uniqueBinarySearch(1, n);
    }

    private List<TreeNode> uniqueBinarySearch(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end) {
            list.add(null);
            return list;
        }
        else if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        else {
            for(int i = start; i <= end; i++) {
                List<TreeNode> pLeft = uniqueBinarySearch(start, i - 1);
                List<TreeNode> pRight = uniqueBinarySearch(i + 1, end);
                for(TreeNode left : pLeft) {
                    for(TreeNode right : pRight) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        list.add(node);

                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
//        System.out.println(new UniqueBinarySearchTree().numTrees(10));
//        int[] arr1 = new int[]{1, 3, 5, 7, 9};
//        int[] arr2 = new int[]{2, 4, 6, 8, 10};
//        LinkedNode node1 = new UniqueBinarySearchTree().create(arr1);
//        LinkedNode node2 = new UniqueBinarySearchTree().create(arr2);
//        LinkedNode node = new UniqueBinarySearchTree().merge(node1, node2);
        UniqueBinarySearchTree unique = new UniqueBinarySearchTree();
        System.out.println(unique.uniqueBinarySearch(10));
    }

    class LinkedNode {
        int val;
        LinkedNode(int val) {
            this.val = val;
        }
        LinkedNode next;
    }

    public LinkedNode merge(LinkedNode node1, LinkedNode node2) {
        LinkedNode result = null;
        if(node1 == null && node2 == null) return result;
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val < node2.val) {
            result = node1;
            result.next = merge(node1.next, node2);
        }
        else {
            result = node2;
            result.next = merge(node1, node2.next);
        }
        return result;
    }

    public LinkedNode create(int[] arr) {
        if(arr.length == 0) return null;
        LinkedNode root = new LinkedNode(arr[0]);
        LinkedNode node = root;
        for(int i = 1; i < arr.length; i++) {
            node.next = new LinkedNode(arr[i]);
            node = node.next;
        }
        return root;
    }

}
