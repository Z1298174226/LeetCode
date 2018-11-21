package com.zhao.lex.leetcode;

import java.util.ArrayList;

/**
 * Created by qtfs on 2018/11/21.
 */
public class StringArrangement {
    public ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        boolean[] marked = new boolean[array.length];
        dfs(result, array, marked, 0, builder);
        return result;
    }

    private void dfs(ArrayList<String> result, char[] array, boolean[] marked, int index, StringBuilder builder) {
        if(index == array.length) {
            StringBuilder newBuilder = new StringBuilder(builder);
            if(!result.contains(newBuilder.toString()))
                result.add(newBuilder.toString());
            return;
        }
        else {
            for(int i = 0; i < array.length; i++) {
                if(!marked[i]) {
                    builder.append(array[i]);
                    marked[i] = true;
                    dfs(result, array, marked, index + 1, builder);
                    builder.deleteCharAt(builder.length() - 1);
                    marked[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new StringArrangement().Permutation("abcdefgf"));
    }
}
