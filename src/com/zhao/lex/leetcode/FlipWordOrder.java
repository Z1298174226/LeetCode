package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/21.
 */
public class FlipWordOrder {
    public String ReverseSentence(String str) {
        if(str.equals("")) return "".toString();
        if(str.equals(" ")) return " ".toString();
        String[] array = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--)
            builder.append(array[i] + (i == 0 ? "" : " "));
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FlipWordOrder().ReverseSentence(" "));
    }
}
