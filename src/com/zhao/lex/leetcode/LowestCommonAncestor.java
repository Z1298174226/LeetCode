package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/22.
 */
public class LowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }

    public TreeNode getLowestCommonAncestor(TreeNode pRoot, TreeNode pLeft, TreeNode pRight) {
        if(pRoot == null || pRoot == pLeft || pRoot == pRight)
            return pRoot;
        TreeNode left = getLowestCommonAncestor(pRoot.left, pLeft, pRight);
        TreeNode right = getLowestCommonAncestor(pRoot.right, pLeft, pRight);
        if(left != null && right != null)
            return pRoot;
        return left == null ? right : left;
    }

    public TreeNode getLowestCommonAncestorBST(TreeNode pRoot, TreeNode pLeft, TreeNode pRight) {
        if(pRight.val < pLeft.val) return null;
        if(pRoot == null || pRoot == pLeft || pRoot == pRight)
            return pRoot;
        TreeNode node = null;
        if(pRoot.val > pRight.val)
            node = getLowestCommonAncestorBST(pRoot.left, pLeft, pRight);
        else if(pRoot.val < pLeft.val)
            node = getLowestCommonAncestorBST(pRoot.right, pLeft, pRight);
        if(node.val >= pLeft.val && node.val <= pRight.val)
            return node;
        return node;
    }

    public static void main(String[] args) {
    }
}
