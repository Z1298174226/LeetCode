package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class ReturnType {
    int max;
    int min;
    int maxNumber;
    TreeNode headNode;

    public ReturnType(int min, int max, int maxNumber, TreeNode headNode) {
        this.min = min;
        this.max = max;
        this.maxNumber = maxNumber;
        this.headNode = headNode;
    }
}
