package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/20.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) return false;
        int length = num.length();
        boolean flag = false;
        for(int i = 1; i < num.length(); i++) {
            long num1 = Long.valueOf(num.substring(0, i));
            for(int j = i + 1; j < num.length(); j++) {
                if(num.substring(0, i).startsWith("0") && num.substring(0, i).length() > 1) break;
                long num2 = Long.valueOf(num.substring(i, j));
                if(num.substring(i, j).startsWith("0")) break;
                flag = dfs(num1, num2, num, j);
                if(flag)
                    return flag;
            }
        }
        return flag;
    }

    private boolean dfs(long num1, long num2, String num, int index) {
        if(index == num.length())  return true;
        boolean flag = false;
        for(int i = index + 1; i <= num.length(); i++) {
            if(num.substring(index, i).startsWith("0")) break;
            long num3 = Long.valueOf(num.substring(index, i));
            if(num3 == num1 + num2)
                flag = flag || dfs(num2, num3, num, i);
            if(flag)
                return flag;
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "1023";
        System.out.println(new AdditiveNumber().isAdditiveNumber(s));
    }
}
