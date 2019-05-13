package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/5/6.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        ReturnType type = dfs(root);
        System.out.println(root);
        System.out.println(type.headNode);
        return root == type.headNode;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class ReturnType {
        long min;
        long max;
        TreeNode headNode;
        int maxNode;
        ReturnType(long min, long max, TreeNode headNode, int maxNode) {
            this.min = min;
            this.max = max;
            this.headNode = headNode;
            this.maxNode = maxNode;
        }
    }

    private ReturnType dfs(TreeNode node) {
        if(node == null)
            return new ReturnType(Long.MAX_VALUE, Long.MIN_VALUE, null, 0);
        ReturnType lData = dfs(node.left);
        ReturnType rData = dfs(node.right);
        long min = Math.min(Math.min(lData.min, rData.min), node.val);
        long max = Math.max(Math.max(lData.max, rData.max), node.val);
        int maxNode = Math.max(lData.maxNode, rData.maxNode);
        TreeNode headNode = lData.maxNode > rData.maxNode ? lData.headNode : rData.headNode;
        if(node.val > lData.max && node.val < rData.min && node.left == lData.headNode && node.right == rData.headNode) {
            maxNode = lData.maxNode + rData.maxNode + 1;
            headNode = node;
        }
        return new ReturnType(min, max, headNode, maxNode);

    }

    public static void main(String[] args) {
        ValidateBinarySearchTree valid = new ValidateBinarySearchTree();
        TreeNode root = valid.new TreeNode(2147483647);
       // root.left = valid.new TreeNode(1);
//        root.right = valid.new TreeNode(1);
        System.out.println(valid.isValidBST(root));

    }
}
