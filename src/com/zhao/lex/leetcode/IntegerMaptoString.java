package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2019/4/7.
 */
public class IntegerMaptoString {
    public static void main(String[] args) {
        int num = 12121212;
        new IntegerMaptoString().function(num);
    }

    public void function(int num) {
        List<List<String>> list = new IntegerMaptoString().integerMaptoString(num);
        List<String> result = new ArrayList<String>();
        for(List<String> li : list) {
            StringBuilder builder = new StringBuilder();
            boolean flag = true;
            for(String s : li) {
                int a = Integer.valueOf(s);
                if(a < 0 || a > 26) {
                    flag = false;
                    break;
                }
                else {
                    builder.append((char)('a' + a - 1));
                }
            }
            if(flag) {
                result.add(builder.toString());
            }
        }
        System.out.println(result);
    }

    public List<List<String>> integerMaptoString(int num) {
        String s = String.valueOf(num);
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(result, list, s, 0, 1);
        dfs(result, list, s, 0, 2);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, String s, int start, int end) {
        if(end > s.length()) return;
        if(end == s.length()) {
            List<String> newList = new ArrayList<String>(list);
            newList.add(s.substring(start, end));
            if(!result.contains(newList)) {
                result.add(newList);
            }
        }
        else {
            list.add(s.substring(start, end));
            dfs(result, list, s, end, end + 1);
            dfs(result, list, s, end, end + 2);
            list.remove(list.size() - 1);
        }
    }
}
