package com.zhao.lex.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qtfs on 2019/5/27.
 */
public class ReverseTreeNode {
    public List<TreeNode> preReverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                list.add(current);
                stack.add(current);
                current = current.left;
            }
            if(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                current = node.right;
            }
        }
        return list;
    }

    public List<TreeNode> inReverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.add(current);
                current = current.left;
            }
            if(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node);
                current = node.right;
            }
        }
        return list;
    }

    public List<TreeNode> postReverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode current = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(current != null) {
            stack.add(current);
            current = current.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null && node.right != last) {
                current = node.right;
                stack.add(node);
                while(current != null) {
                    stack.add(current);
                    current = current.left;
                }
            }
            else {
                list.add(node);
                last = node;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ReverseTreeNode reverse = new ReverseTreeNode();
        System.out.println(reverse.preReverse(TreeNodeFactory.getInstance()));
        System.out.println(reverse.inReverse(TreeNodeFactory.getInstance()));
        System.out.println(reverse.postReverse(TreeNodeFactory.getInstance()));
    }
}
