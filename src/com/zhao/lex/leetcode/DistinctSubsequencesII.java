package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qtfs on 2018/11/23.
 */
public class DistinctSubsequencesII {
    public int distinctSubseqII(String S) {
        if(S == null || S.equals("")) return 0;
        int length = S.length();
        char[] array = S.toCharArray();
        List<String> list = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            for (int j = 1; j <= length; j++)
                dfs(array, i, 0, j, list, builder);
        }
        return list.size();
    }

    private void dfs(char[] array, int index, int j, int k, List<String> list, StringBuilder builder) {
        if(index == array.length || j == k) {
            StringBuilder newBuilder = new StringBuilder(builder);
            if(!list.contains(newBuilder.toString()))
                list.add(newBuilder.toString());
            return;
        }
        for(int i = index; i < array.length; i++) {
            builder.append(array[i]);
            j++;
            dfs(array, i + 1, j, k, list, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public int distinctSubseqI(String S) {
//        int n = S.length();
//        int[] count = new int[26];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            int index = S.charAt(i) - 'a';
//            int cur = (1 + sum - count[index]);
//            sum = sum + cur;
//            count[index] = count[index] + cur;
//        }
//        return sum;

        int n = S.length(),  result = 0;
        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        for(int i = 2; i < n; i++)
        dp[2] = 1;
        for (int i = 0; i < n; i++) {
            int j = i - 2;
            if(j >= 0) {
                if(S.charAt(j) != S.charAt(i))
                    dp[i] += dp[j];
            }
//            for (int j = 0; j < i; j++) {
//                if (S.charAt(j) != S.charAt(i)) {
//                    dp[i] += dp[j];
//                }
//            }
            result += dp[i];
        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(new DistinctSubsequencesII().distinctSubseqI("abcd"));

    }
}
