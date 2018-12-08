package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/11/30.
 */
public class CountofSmallerNumbersAfterSelf {
    class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;
        int count;
        int lessThan;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private List<TreeNode> list = new ArrayList<TreeNode>();

    public int getSmaller(TreeNode node, int val) {
        if(node == null) {
            node = new TreeNode(val);
            return 0;
        }
        if(node.val == val) {
            node.count++;
            return node.lessThan;
        }
        else if(node.val > val) {
            node.lessThan++;
            return getSmaller(node.left, val);
        }
        else
            return node.count + node.lessThan + getSmaller(node.right, val);
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode root = null;
        for(int i = 0; i < nums.length; i++)
            list.add(getSmaller(root, nums[i]));
        return list;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(new CountofSmallerNumbersAfterSelf().countSmaller(nums));
    }
}
