package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/2/27.
 */
public class removeDupMethod {
    public static void removeMethod(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        int i = 0;
        boolean flag = false;
        for (i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) != s.lastIndexOf(c)) {
                flag = false;
            } else {
                flag = true;
            }
            if (i == s.indexOf(c))
                flag = true;
            if (flag) {
                sb.append(c);
            }
        }
        System.out.print(sb.toString());
    }

    public static void removeMethodII(String s) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[256];
        for(int i = 0; i < s.length(); i++) {
            if(cnt[s.charAt(i)] == 0) {
                sb.append(s.charAt(i));
                cnt[s.charAt(i)]++;
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        removeMethodII("zhaoxudong");
    }
}
