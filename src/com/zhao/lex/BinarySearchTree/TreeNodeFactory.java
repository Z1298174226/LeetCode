package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class TreeNodeFactory {

    private static volatile TreeNode root = null;
    static {
        root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(11);
    }
    private TreeNodeFactory(){}

    public static TreeNode getInstance() {
        return root;
    }

    public static TreeNode getOne() {
        return root.left.left;
    }

    public static TreeNode getAnother() {
        return root.left.right;
    }
}
