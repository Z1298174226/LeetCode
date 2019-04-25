package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/22.
 */
public class NumberToString {
    public int num2(String str) {
        if(str == null || str.length() == 0)
            return 0;
        char[] chs = str.toCharArray();
        int cur = chs[chs.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int temp = 0;
        for(int i = chs.length - 2; i >= 0; i--) {
            if(chs[i] == '0') {
                next = cur;
                cur = 0;
            }else {
                temp = cur;
                if((chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = temp;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        NumberToString plat = new NumberToString();
        System.out.println(plat.num2("11"));
    }
}
