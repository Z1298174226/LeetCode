package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/11/17.
 */
public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0 || envelopes == null) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
        int result = 1;
        int[][] B = new int[envelopes.length + 1][2];
        B[result][0] = envelopes[0][0]; B[result][1] = envelopes[0][1];
        for(int i = 1; i < envelopes.length; i++) {
            int pos = help(B, 1, result, envelopes[i][0], envelopes[i][1]);
            if(pos > result || (pos == 1 && B[result][1] > envelopes[i][1] && B[result][0] == envelopes[i][0])||(pos > 1 && pos == result && B[result][1] > envelopes[i][1] && B[result - 1][1] < envelopes[i][1])) {
                B[pos][0] = envelopes[i][0];
                B[pos][1] = envelopes[i][1];
            }
            result = Math.max(pos, result);
        }
        return result;
    }

    public static int help(int[][] B, int start, int end, int comparatorW, int comparatorH) {
        if(B[end][0] < comparatorW && B[end][1] < comparatorH) return end + 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(B[mid][0] < comparatorW && B[mid][1] < comparatorH) start = mid + 1;
            else if(B[mid][0] > comparatorW && B[mid][1] > comparatorH) end = mid;
            else break;
        }
        return end;
    }

    public static void main(String[] args) {
        //int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes = new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
       // int[][] envelopes = new int[][]{{3, 4}, {12, 2}, {12 ,15}, {30, 50}};
        System.out.println(RussianDollEnvelopes.maxEnvelopes(envelopes));
    }
}
