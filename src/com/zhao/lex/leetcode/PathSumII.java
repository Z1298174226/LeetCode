package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2019/3/15.
 */
public class PathSumII {

    class TreeNode {
        int val;
        TreeNode() {
            this.val = val;
        }
        TreeNode right;
        TreeNode left;
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, sum, result, list);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if(root == null && sum == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(root == null && sum != 0) return;
        list.add(root.val);
        if(root.right == null && root.left == null) dfs(root.right, sum - root.val, result, list);
        else if(root.right == null && root.left != null) dfs(root.left, sum - root.val, result, list);
        else if(root.right != null && root.left == null) dfs(root.right, sum - root.val, result, list);
        else {
            dfs(root.left, sum - root.val, result, list);
            dfs(root.right, sum - root.val, result, list);
        }
        list.remove(list.size() - 1);


    }
    public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        int result = 0;
        dfs(root, list, builder);
        for(String s : list) {
            result += Integer.valueOf(s);
        }
        return result;
    }

    public void dfs(TreeNode root, List<String> list, StringBuilder builder) {
        if(root == null) return;
        if(root != null && root.left == null && root.right == null) {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append(Integer.toString(root.val));
            list.add(newBuilder.toString());
            return;
        }
        builder.append(Integer.toString(root.val));
        int length = Integer.toString(root.val).length();
        dfs(root.left, list, builder);
        dfs(root.right, list, builder);
        builder.delete(builder.length() - length, builder.length());
    }
}
