package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qtfs on 2017/12/26.
 */
public class NQueensII {
//    private Set<Integer> occupiedCol = new HashSet<Integer>();
//    private Set<Integer> occupiedDigit_1 = new HashSet<Integer>();
//    private Set<Integer> occupiedDigit_2 = new HashSet<Integer>();
    private List<Integer> occupiedCol = new ArrayList<Integer>();
    private List<Integer> occupiedDigit_1 = new ArrayList<Integer>();
    private List<Integer> occupiedDigit_2 = new ArrayList<Integer>();
    public int totalNQueens(int n) {
        List<List<String>> lists = new ArrayList<List<String>>();
        int[] pos = new int[n];
        int count = dfs(lists, 0, 0, n, pos);
        for(List<String> list : lists) {
            for(String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
        return count;
    }

    private int dfs(List<List<String>> res, int row, int count, int n, int[] pos) {
        for(int col = 0; col < n; col ++) {
            if(occupiedCol.contains(col))
                continue;
            int digit_1 = row - col;
            if(occupiedDigit_1.contains(digit_1))
                continue;
            int digit_2 = row + col;
            if(occupiedDigit_2.contains(digit_2))
                continue;
            if(row == n - 1) {
                count++;
                List<String> list = new ArrayList();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int c = 0; c < n; c++) {
                        if (c == pos[i]) sb.append(" Q ");
                        else sb.append(" . ");
                    }
                    list.add(sb.toString());
                }
                res.add(list);
            }
            else {
                pos[row] = col;
                occupiedCol.add(col);
                occupiedDigit_1.add(digit_1);
                occupiedDigit_2.add(digit_2);
                count = dfs(res, row + 1, count, n, pos);
//                occupiedCol.remove(col);
//                occupiedDigit_1.remove(digit_1);
//                occupiedDigit_2.remove(digit_2);
                occupiedCol.remove(occupiedCol.size() - 1);
                occupiedDigit_1.remove(occupiedDigit_1.size() - 1);
                occupiedDigit_2.remove(occupiedDigit_2.size() - 1);

            }
        }
        return count;
    }



    public static void main(String[] args) {
        NQueensII nq = new NQueensII();
        System.out.println(nq.totalNQueens(8));
    }
}
