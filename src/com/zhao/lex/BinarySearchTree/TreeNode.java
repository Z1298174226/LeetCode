package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class TreeNode {
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "[Node " + val + "]";
    }
}
