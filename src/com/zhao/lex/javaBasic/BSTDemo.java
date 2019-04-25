package com.zhao.lex.javaBasic;

import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by qtfs on 2019/3/11.
 */
public class BSTDemo {
    class Node {
        int val;
        Node(int val) {
            this.val = val;
        }
        Node left;
        Node right;
    }

    public Node initBST(int[] arr) {
        int length = arr.length;
        if(length == 1)
            return new Node(arr[0]);
        else {
            List<Node> list = new ArrayList<Node>();
            for(int i = 0; i < length; i++)
                list.add(new Node(arr[i]));
            int temp = 0;
            while(temp <= length / 2 - 1) {
                if(temp * 2 + 1 < length)
                    list.get(temp).left = list.get(temp * 2 + 1);
                if(temp * 2 + 2 < length)
                    list.get(temp).right = list.get(temp * 2 + 2);
                temp++;
            }
            return list.get(0);
        }
    }

    public void preTraver(Node root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preTraver(root.left);
        preTraver(root.right);
    }

    public void midTraver(Node root) {
        if(root == null)
            return;
        midTraver(root.left);
        System.out.print(root.val + " ");
        midTraver(root.right);
    }

    public void postTraver(Node root) {
        if(root == null)
            return;
        postTraver(root.left);
        postTraver(root.right);
        System.out.print(root.val + " ");
    }

    public void preTraverUpd(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while(p != null || !stack.isEmpty()) {
            while(p != null) {
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()) {
                Node node = stack.pop();
                p = node.right;
            }
        }
    }

    public void postTraverUpd(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node cur = null;
        Node pre = null;
        while(!stack.isEmpty()) {
            cur = stack.peek();
            if((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))) {
                Node node = stack.pop();
                System.out.print(node.val + " ");
                pre = node;
            }
            else {
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }

    }

    public void midTraverUpd(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while(p != null || !stack.isEmpty()) {
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.val + " ");
                p = node.right;
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0 ; i < 100; i++)
            arr[i] = i;
        BSTDemo.Node root = new BSTDemo().initBST(arr);
        new BSTDemo().preTraver(root);
        System.out.println();
        new BSTDemo().midTraver(root);
        System.out.println();
        new BSTDemo().postTraver(root);
        System.out.println();
        new BSTDemo().preTraverUpd(root);
        System.out.println();
        new BSTDemo().midTraverUpd(root);
        System.out.println();
        new BSTDemo().postTraverUpd(root);

    }
}
