package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2019/5/6.
 */
public class NumberOfSubstring {
    public int numberOfSubstring(String s) {
        int max = 0;
        int count = 1;
        String maxSubstr = null;
        int len = s.length();
        int gap = 0;
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < len; i++)
            list.add(s.substring(i));
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                count = 1;
                gap = j - i + 1;
                if(gap <= list.get(i).length() && gap <= list.get(j).length() && list.get(i).substring(0, gap).equals(list.get(j).substring(0, gap))) {
                    count++;
                    for(int k = j + gap; k < len; k += gap) {
                        if(gap <= list.get(i).length() && gap <= list.get(k).length() && list.get(i).substring(0, gap).equals(list.get(k).substring(0, gap)))
                            count++;
                        else
                            break;
                    }
                    if(count > max) {
                        max = count;
                        maxSubstr = list.get(i).substring(0, gap);
                    }
                }
            }
        }
        System.out.println(maxSubstr);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubstring().numberOfSubstring("zoohaoooooocoo"));
    }
}
