package com.zhao.lex.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2018/1/10.
 */
public class StickerstoSpellWord {
    public static int minStickers(String[] stickers, String target) {
        if(target.length() == 0) return 0;
        int n = stickers.length;
        int[][] mp = new int[n][26];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < stickers[i].length(); j++)
                mp[i][stickers[i].charAt(j) - 'a']++;
        }
        Map<String , Integer> dp = new HashMap<String, Integer>();
        dp.put("", 0);
        return help(mp, dp, target);
    }

    private static int help(int[][] mp,Map<String, Integer> dp, String target) {
        if(dp.containsKey(target)) return dp.get(target);
        int ans = Integer.MAX_VALUE;
        int n = mp.length;
        int[] tar = new int[26];
        for(int i = 0; i < target.length(); i++)
            tar[target.charAt(i) - 'a']++;
        for(int i = 0; i <n; i++) {
            if(mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                    builder.append((char)(j + 'a'));
                }
            }
           String s = builder.toString();
            if(s.length() != target.length()) {
                int temp = help(mp, dp, s);
                if(temp != -1) ans = Math.min(ans, temp + 1);
            }
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }

    public static void main(String[] args) {
        String[] stickers = new String[]{"with", "example", "science"};
        String target = "themaththemathsz";
        System.out.println(minStickers(stickers, target));

    }
}
