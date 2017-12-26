package com.zhao.lex.leetcode;


import java.util.*;

/**
 * Created by qtfs on 2017/12/26.
 */
public class NumberofAtoms {
    public static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int i = 0;
        int n = formula.length();
        while(i < n) {
            char c = formula.charAt(i++);
            if(c == '(') {
                stack.push(map);
                map = new HashMap<String, Integer>();
            }
            else if(c == ')') {
                int val = 0;
                while(i < n && Character.isDigit(formula.charAt(i)))
                    val = val * 10 + formula.charAt(i++) - '0';
                if(val == 0) val = 1;
                if(!stack.isEmpty()) {
                    Map<String, Integer> temp = map;
                    map = stack.pop();
                    for(String key : temp.keySet())
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key) * val);
                }
            }
            else {
                int start = i - 1;
                while(i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String s = formula.substring(start, i);
                int val = 0;
                while(i < n && Character.isDigit(formula.charAt(i)))
                    val = val * 10 + formula.charAt(i++) - '0';
                if(val == 0) val = 1;
                map.put(s, map.getOrDefault(s, 0) + val);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list);
        for(String key : list) {
            sb.append(key);
            if(map.get(key) > 1) sb.append(map.get(key));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String h2o = "KAl(SO3)2(H2O)12";
        System.out.println(countOfAtoms(h2o));
    }
}
