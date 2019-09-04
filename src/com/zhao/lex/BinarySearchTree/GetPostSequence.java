package com.zhao.lex.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qtfs on 2019/5/27.
 */
public class GetPostSequence {
    public void getPostSequence(int[] pre, int[] in) {
        if(pre.length != in.length) return;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < in.length; i++)
            map.put(in[i], i);
        dfs(map, pre, 0, pre.length - 1, 0);
    }

    private void dfs(Map<Integer, Integer> map, int[] pre, int left, int right, int index) {
        if(left > right) return;
        int pos = map.get(pre[index]);
        int leftSize = pos - left;
        dfs(map, pre, left, pos - 1, index + 1);
        dfs(map, pre, pos + 1, right, index + leftSize + 1);
        System.out.println(pre[index]);
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 2, 1, 4, 5};
        int[] in = new int[]{1, 2, 3, 4, 5};
        new GetPostSequence().getPostSequence(pre, in);
    }
}
