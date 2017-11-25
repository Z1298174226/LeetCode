package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/24.
 */
public class LongestSameCharSubstring {
    public static int longestSubstring(String s) {
        int left = 0;
        if(s.length() < 2) return 0;
        int result = 0;
        while(left < s.length()) {
            boolean marked = false;
            int right = left;
            char compare = s.charAt(left);
            while (right < s.length()) {
                if (s.charAt(right) == s.charAt(left))
                    right++;
                else if (s.charAt(right) == compare)
                    right++;
                else if (marked)
                    break;
                else {
                    marked = true;
                    compare = s.charAt(right);
                    right++;
                }
            }
            if (right == s.length())
                result = Math.max(result, right - left);
            else
                result = Math.max(result, right - left + 1);
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "rsrsrrrrrrsssssssssssssrrrrrrrrrrrrrssssrsrsrsrsrsrsrssssssssssssssssrrrrrrrrrrrrrrrsrrrrrrrrrrrrrrrrrrrsrrrrr";
        System.out.println(LongestSameCharSubstring.longestSubstring(s));
    }
}
