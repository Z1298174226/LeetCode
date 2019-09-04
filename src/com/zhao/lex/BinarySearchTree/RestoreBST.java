package com.zhao.lex.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qtfs on 2019/5/27.
 */
public class RestoreBST {
    public TreeNode getPostSequence(int[] pre, int[] in) {
        if(pre.length != in.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++)
            map.put(in[i], i);
        return dfs(map, pre, 0, pre.length - 1, 0);
    }

    private TreeNode dfs(Map<Integer, Integer> map, int[] pre, int left, int right, int index) {
        if(left > right) return null;
        int pos = map.get(pre[index]);
        int leftSize = pos - left;
        TreeNode root = new TreeNode(pre[index]);
        TreeNode leftNode = dfs(map, pre, left, pos - 1, index + 1);
        TreeNode rightNode = dfs(map, pre, pos + 1, right, index + leftSize + 1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public TreeNode getPreSequence(int[] post, int[] in) {
        if(post.length != in.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++)
            map.put(in[i], i);
        return dfsUpdate(post, map, 0, post.length - 1, post.length - 1);
    }

    private TreeNode dfsUpdate(int[] post, Map<Integer, Integer> map, int left, int right, int index) {
        if(left > right) return null;
        int pos = map.get(post[index]);
        int rightSize = right - pos;
        TreeNode node = new TreeNode(post[index]);
        TreeNode lNode = dfsUpdate(post, map, left, pos - 1, index - rightSize - 1);
        TreeNode rNode = dfsUpdate(post, map, pos + 1, right, index - 1);
        node.left = lNode;
        node.right = rNode;
        return node;
    }
}
