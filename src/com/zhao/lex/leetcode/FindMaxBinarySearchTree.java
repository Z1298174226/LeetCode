package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/25.
 */
public class FindMaxBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }
    class ReturnType {
        TreeNode maxBSTHead;
        int maxBSTSize;
        int min;
        int max;

        ReturnType(TreeNode maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public ReturnType process(TreeNode root) {
        if(root == null)
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        ReturnType lData = process(root.left);
        ReturnType rData = process(root.right);
        int min = Math.min(root.val, Math.min(lData.min, rData.min));
        int max = Math.max(root.val, Math.max(lData.max, rData.max));
        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        TreeNode maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;
        if(lData.maxBSTHead == root.left && rData.maxBSTHead == root.right && root.val > lData.max && root.val < rData.min) {
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = root;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    public TreeNode getMaxBinarySearchTree(TreeNode root) {
        return process(root).maxBSTHead;
    }


}
