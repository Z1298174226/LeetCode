package com.zhao.lex.leetcode;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map;
/**
 * Created by qtfs on 2018/6/26.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int m = n - k;

        if (m == 0) {
            return "0";
        }

        Map<Integer, TreeSet<Integer>> num2pos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int val = num.charAt(i) - '0';
            if (!num2pos.containsKey(val)) {
                num2pos.put(val, new TreeSet<>());
            }
            num2pos.get(val).add(i);
        }

        StringBuilder res = new StringBuilder();

        int start = 0;
        int end = n - m;
        for (int i = 0; i < m; ++i) {
            int cand = 0;
            for (int j = 0; j <= 9; ++j) {
                if (!num2pos.containsKey(j)) {
                    continue;
                }
                Integer pos = num2pos.get(j).ceiling(start);
                if (pos != null && pos <= end) {
                    cand = j;
                    start = pos + 1;
                    ++end;
                    break;
                }
            }
            res.append(cand);
        }

        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            ++i;
        }

        String str = i == res.length() ? "0" : res.substring(i, res.length());
        return str;
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("1637293432", 4));
    }
}
