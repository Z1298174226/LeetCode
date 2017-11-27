package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/26.
 */
public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        if(s == "") return "";
        int start = 0, end = s.length() - 1, i = start, j = end;
        char chs[] = s.toCharArray();
        while(i < j) {
            if (chs[i] == chs[j]) {
                i++; j--;
            } else {
                i = 0; end--; j = end;
            }
        }
        String result_one =  new StringBuilder(s.substring(end+1)).reverse().toString() + s;
        while(i < j) {
            if (chs[i] == chs[j]) {
                i++; j--;
            } else {
                j = end; start++; i = start;
            }
        }
        String result_two =  s + new StringBuilder(s.substring(0, start + 1)).reverse().toString();
        return result_one.length() > result_two.length() ? result_two : result_one;
    }
    public static class Test {
        public static void main(String[] args) {
            String testS = "edabad";
            System.out.println(shortestPalindrome(testS));
        }
    }
}
