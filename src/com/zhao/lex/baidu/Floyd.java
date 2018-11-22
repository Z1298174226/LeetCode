package com.zhao.lex.baidu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qtfs on 2018/4/18.
 */
public class Floyd {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;
        TreeNode(int value) {
            value = value;
        }
    }

    public static TreeNode build() {
        Queue<TreeNode> queue = new LinkedList<>();
        int n = 0;
        TreeNode root = new TreeNode(++n);
        queue.add(root);
        for(int i = 0; i < 10; i++) {
           if(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                node.left = new TreeNode(i);
                node.right = new TreeNode(i);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void display(TreeNode root) {
        if(root == null) return;
        display(root.left);
        System.out.println(root.value);
        display(root.right);

    }
    public static void main(String[] args) {
        TreeNode root = build();
        display(root);
    }
}
