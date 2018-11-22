package com.zhao.lex.goalsToOffer.backtracking;

/**
 * Created by qtfs on 2018/4/25.
 */
public class Solution1 {
    public static String ReverseSentence(String str) {
        String[] strs = str.split(" ");
        System.out.println(strs.length);
        int length = strs.length;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            builder.append(strs[length - i - 1]);
            if(i != length - 1)
                builder.append(" ");
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }
}
