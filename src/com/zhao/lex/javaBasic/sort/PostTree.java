package com.zhao.lex.javaBasic.sort;

import java.util.Stack;

/**
 * Created by qtfs on 2019/4/20.
 */
public class PostTree {
    class TreeNode {
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }

    public void postTree(TreeNode node) {
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = node;
        TreeNode lastNode = null;
        while(currentNode != null) {
            stack.add(currentNode);
            currentNode = currentNode.left;
        }
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp.right != null && temp.right != lastNode) {
                currentNode = temp.right;
                stack.add(temp);
                while(currentNode != null) {
                    stack.add(currentNode);
                    currentNode = currentNode.left;
                }
            }
            else {
                System.out.println(temp.val);
                lastNode = temp;
            }
        }

    }

    public void preOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()) {
            while(currentNode != null) {
        //        System.out.println(currentNode.val);
                stack.add(currentNode);
                currentNode = currentNode.left;
            }
            if(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                System.out.println(temp.val);
                currentNode = temp.right;
            }
        }
    }

    public TreeNode createTree(int[] arr) {
        return createTreeNode(arr, 0, arr.length - 1);
    }

    private TreeNode createTreeNode(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        TreeNode left = createTreeNode(arr, start, mid - 1);
        TreeNode right = createTreeNode(arr, mid + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
     //   new PostTree().postTree(new PostTree().createTree(arr));
        new PostTree().preOrder(new PostTree().createTree(arr));
    }

}
