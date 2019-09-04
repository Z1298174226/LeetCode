package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class FlipOperation {
    public boolean isFlipTree(TreeNode node1, TreeNode node2) {
        if(node1 == node2)
            return true;
        if(node1.val != node2.val || node1 == null || node2 == null)
            return false;
        return (isFlipTree(node1.left, node2.left) && isFlipTree(node1.right, node2.right)) ||
                (isFlipTree(node1.left, node2.right) && isFlipTree(node1.right, node2.left));

    }

    public static void main(String[] args) {
        System.out.println(new FlipOperation().isFlipTree(TreeNodeFactory.getInstance(), BinaryTreeUtil.swapTreeNode(TreeNodeFactory.getInstance())));
    }
}
