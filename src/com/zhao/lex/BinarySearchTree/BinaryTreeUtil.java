package com.zhao.lex.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qtfs on 2019/5/27.
 */
public class BinaryTreeUtil {
    /**
     * 反转二叉树
     *
     * @param root
     * @return
     */
    public static TreeNode swapTreeNode(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        swapTreeNode(root.left);
        swapTreeNode(root.right);
        return root;
    }

    /**
     * 镜像二叉树
     *
     * @param root
     * @return
     */
    public static boolean isMirorBinaryTree(TreeNode root) {
        if (root == null) return false;
        return isMirorBinaryTree(root.left, root.right);
    }

    private static boolean isMirorBinaryTree(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left.val != right.val || left == null || right == null) return false;
        return isMirorBinaryTree(left.left, right.right) && isMirorBinaryTree(left.right, right.left);
    }

    /**
     * 判断是否为二叉搜索树，非中序遍历方式
     *
     * @param root
     * @return
     */
    public static boolean isBinarySearchTree(TreeNode root) {
        return root == maxBinarySearchTreeSubStructure(root).headNode;
    }

    private static ReturnType maxBinarySearchTreeSubStructure(TreeNode root) {
        if (root == null)
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, null);
        ReturnType lData = maxBinarySearchTreeSubStructure(root.left);
        ReturnType rData = maxBinarySearchTreeSubStructure(root.right);
        int min = Math.min(Math.min(lData.min, rData.min), root.val);
        int max = Math.max(Math.max(lData.max, rData.max), root.val);
        int maxNumber = lData.maxNumber > rData.maxNumber ? lData.maxNumber : rData.maxNumber;
        TreeNode headNode = lData.maxNumber > rData.maxNumber ? lData.headNode : rData.headNode;
        if (lData.max < root.val && root.left == lData.headNode && rData.min > root.val && root.right == rData.headNode) {
            maxNumber = rData.maxNumber + lData.maxNumber + 1;
            headNode = root;
        }
        return new ReturnType(min, max, maxNumber, headNode);
    }

    /**
     * 判断是否为完全二叉树
     *
     * @param root
     * @return
     */
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean leaf = false;
        queue.add(root);
        while(!queue.isEmpty()) {
           TreeNode node = queue.poll();
           if(node.left == null && node.right != null) return false;
           if(leaf && (node.left != null || node.right != null)) return false;
           if(node.left != null)
               queue.add(node.left);
           if(node.right != null) {
                queue.add(node.right);
           }
           else {
               leaf = true;
           }
        }
        return true;
    }
}
