package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/12/18.
 */
public class OfoCombinationII {
    public static void ofoCombination(int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(lists, list, 1, n, n - 1);
        for(List<Integer> li : lists) {
            for(int num : li) {
                System.out.print(String.format("%3d", num));
            }
            System.out.println();
        }
        System.out.println(lists.size());
    }

    private static void dfs(List<List<Integer>> lists, List<Integer> list, int index, int n, int k) {
        if(k == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = index; i <=n; i++) {
            list.add(i);
            dfs(lists, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        ofoCombination(4);
    }
}
