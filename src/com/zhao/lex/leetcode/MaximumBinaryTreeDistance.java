package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/27.
 */
public class MaximumBinaryTreeDistance {
    class TreeNode {
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }

    class ReturnType {
        int height;
        int maxDistance;
        ReturnType(int height, int maxDistacne) {
            this.height = height;
            this.maxDistance = maxDistacne;
        }
    }

    private int result = 0;

    public int maximumBinaryTreeDistance(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maximumBinaryTreeDistance(root.left);
        int rightHeight = maximumBinaryTreeDistance(root.right);
        result = Math.max(result, 1 + leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public ReturnType process(TreeNode root) {
        if(root == null)
            return new ReturnType(0, 0);
        ReturnType lData = process(root.left);
        ReturnType rData = process(root.right);
        int height = Math.max(lData.height, rData.height) + 1;
        int maxDistance = Math.max(1 + lData.height + rData.height, Math.max(lData.maxDistance, rData.maxDistance));
        return new ReturnType(height, maxDistance);
    }

    public void maximumBinaryTreeDistanceUpdate(TreeNode root) {
        ReturnType returnType =  process(root);
        System.out.println(returnType.maxDistance);
    }

    public static void main(String[] args) {
        MaximumBinaryTreeDistance max = new MaximumBinaryTreeDistance();
        TreeNode root = max.new TreeNode(1);
        root.left = max.new TreeNode(2);
        root.right = max.new TreeNode(3);
        root.right.right = max.new TreeNode(4);
        max.maximumBinaryTreeDistance(root);
        System.out.println(max.result);
        max.maximumBinaryTreeDistanceUpdate(root);
    }
}
