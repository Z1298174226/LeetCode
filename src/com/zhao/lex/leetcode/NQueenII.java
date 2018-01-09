package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/1/8.
 */
public class NQueenII {

    private List<Integer> occupiedCol = new ArrayList<Integer>();
    private List<Integer> occupiedDigit_1 = new ArrayList<Integer>();
    private List<Integer> occupiedDigit_2 = new ArrayList<Integer>();

    public void nQueenII(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] pos = new int[n];
        int count = 0;
        count = dfs(result, count, 0, n, pos);
        System.out.println(count);
        for(List<String> list : result) {
            for(String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private int dfs(List<List<String>> lists, int count, int row, int n, int[] pos) {
        for(int col = 0; col < n; col++) {
            if(occupiedCol.contains(col))
                continue;
            int digit = row + col;
            if(occupiedDigit_1.contains(digit))
                continue;
            int digit2 = row - col;
            if(occupiedDigit_2.contains(digit2))
                continue;
            if(row == n - 1) {
                count++;
                pos[row] = col;
                List<String> list = new ArrayList<String>();
                for(int i = 0; i < n; i++) {
                    StringBuilder builder = new StringBuilder();
                    for(int j = 0; j < n; j++) {
                        if(pos[i] == j)
                            builder.append(" Q ");
                        else
                            builder.append(" . ");
                    }
                    list.add(builder.toString());
                }
                lists.add(list);
            }
            else {
                pos[row] = col;
                occupiedCol.add(col);
                occupiedDigit_1.add(digit);
                occupiedDigit_2.add(digit2);
                count = dfs(lists, count, row + 1, n, pos);
                occupiedCol.remove(occupiedCol.size() - 1);
                occupiedDigit_1.remove(occupiedDigit_1.size() - 1);
                occupiedDigit_2.remove(occupiedDigit_2.size() - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NQueenII n = new NQueenII();
        n.nQueenII(8);
    }
}
