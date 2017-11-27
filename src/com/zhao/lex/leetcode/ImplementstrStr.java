package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/25.
 */
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        if(haystack == "" && needle == "") return 0;
        int left = 0;
        while(left < haystack.length()) {
            int right = left;
            while(right - left < needle.length() && right < haystack.length()) {
                if(haystack.charAt(right) == needle.charAt(right - left))
                    right++;
                else
                    break;
            }
            if(right - left == needle.length()) return left;
            left++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        System.out.println(strStr(haystack, needle));
    }
}
