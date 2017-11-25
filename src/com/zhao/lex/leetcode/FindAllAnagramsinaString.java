package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/19.
 */
public class FindAllAnagramsinaString {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[256];
        int[] now = new int[256];
        for(int i = 0; i < p.length(); i++)
            cnt[p.charAt(i)]++;
        List<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
       while(left < s.length()) {
            while(right < s.length() && now[s.charAt(right)] + 1 <= cnt[s.charAt(right)]) {
                    now[s.charAt(right)] += 1;
                    right++;
            }
            if(right - left == p.length()) list.add(left);
            if(left <= right) now[s.charAt(left)]--;
            left++;
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "ababababababababababa";
        String p = "ab";
        System.out.println(FindAllAnagramsinaString.findAnagrams(s, p));
    }
}
