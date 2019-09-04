package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceOneZero {
    public static void main(String[] args) {
        System.out.println(new ReplaceOneZero().replace("110?11?0011?110?11?0011?110?11?0011?110?11?0011?110?11?0011?110?11?0011?110?11?0011?110?11?0011?110?11?0011?110?11?0011?"));
    }

    public List<String> replace(String str) {
        return dfs(str);
    }

    public List<String> dfs(String str) {
        List<String> result = new ArrayList<>();
        if(str.length() == 1) {
            if(str.equals("?")) {
                result.add("1");
                result.add("0");
            } else {
                result.add(str);
            }
        } else {
            List<String> subList = dfs(str.substring(1));
            for(String sub : subList) {
                if(!str.substring(0, 1).equals("?")) {
                    result.add(str.substring(0, 1) + sub);
                } else {
                    result.add("1" + sub);
                    result.add("0" + sub);
                }
            }
        }
        return result;
    }
}
