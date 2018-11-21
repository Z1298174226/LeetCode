package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/21.
 */
public class StringToInteger {
    public int StrToInt(String str) {
        long result = 0;
        int length = str.length();
        boolean marked = false;
        for(int i = 0; i <= length - 1; i++) {
            if(i == 0 && str.charAt(0) == 43)
                continue;
            else if(i == 0 && str.charAt(0) == 45)
                marked = true;
            else if(str.charAt(i) >= 48 && str.charAt(i) <= 57)
                result += (str.charAt(i) - 48) * Math.pow(10, length - i - 1);
            else
                return 0;
        }
        return marked ? (int)result * -1 : (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().StrToInt("-2147483648"));
    }
}
