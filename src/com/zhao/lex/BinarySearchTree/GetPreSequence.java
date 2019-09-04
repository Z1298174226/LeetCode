package com.zhao.lex.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qtfs on 2019/5/27.
 */
public class GetPreSequence {
    public void getPreSequence(int[] post, int[] in) {
        if(post.length != in.length) return;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < in.length; i++)
            map.put(in[i], i);
        dfs(map, post, 0, post.length - 1, post.length - 1);
    }

    private void dfs(Map<Integer, Integer> map, int[] post, int left, int right, int index) {
        if(left > right) return;
        int pos = map.get(post[index]);
        int rightSize = right - pos;
        System.out.println(post[index]);
        dfs(map, post, left, pos - 1, index - rightSize - 1);
        dfs(map, post, pos + 1, right, index - 1);

    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 2, 1, 4, 5};
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] post = new int[]{1, 2, 5, 4, 3};
        new GetPostSequence().getPostSequence(pre, in);
        new GetPreSequence().getPreSequence(post, in);
    }
}
