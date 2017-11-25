package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/11/25.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[256];
        int result = 0;
        Arrays.fill(cnt, 1);
        int left = 0; int right = 0;
        while(left < s.length()) {
            right = Math.max(left, right);
            while(right < s.length() && cnt[s.charAt(right)] !=  0) {
                cnt[s.charAt(right)]--;
                right++;
            }
            result = Math.max(result, right - left);
            cnt[s.charAt(left)] = 1;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
