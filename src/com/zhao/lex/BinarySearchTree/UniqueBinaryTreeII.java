package com.zhao.lex.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2019/5/27.
 */
public class UniqueBinaryTreeII {
    public List<TreeNode> uniqueBinaryTree(int num) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list = dfs(1, num);
        return list;
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(left > right) return list;
        else if(left == right) {
            list.add(new TreeNode(left));
        }
        else {
            for(int i = left; i <= right; i++) {
                List<TreeNode> lData = dfs(left, i - 1);
                List<TreeNode> rData = dfs(i + 1, right);
                for(TreeNode l : lData) {
                    for(TreeNode r : rData) {
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        list.add(node);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
