package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode left, TreeNode right, TreeNode root) {
        if(root == null || root == left || root == right)
            return root;
        TreeNode lNode = lowestCommonAncestor(left, right, root.left);
        TreeNode rNode = lowestCommonAncestor(left, right, root.right);
        if(lNode != null && rNode != null)
            return root;
        return lNode == null ? rNode : lNode;
    }

    public static void main(String[] args) {
        LowestCommonAncestor low = new LowestCommonAncestor();
        System.out.println(low.lowestCommonAncestor(TreeNodeFactory.getOne(), TreeNodeFactory.getAnother(), TreeNodeFactory.getInstance()));
    }
}
