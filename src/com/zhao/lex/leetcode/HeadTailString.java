package com.zhao.lex.leetcode;


import com.sun.jndi.toolkit.ctx.HeadTail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2019/4/2.
 */
public class HeadTailString {
    public static void main(String[] args) {
//        String[] arr = new String[]{"abcf", "defg", "ghij", "jkl"};
        String[] arr = new String[]{"ghig", "defg", "dkl", "abcd"};
        System.out.println(new HeadTailString().isHeadTailString(arr));
    }

    public int isHeadTailString(String[] arr) {
        List<String> list = new ArrayList<String>();
        int count = arr.length;
        for(String s : arr)
            list.add(s.substring(0, 1));
        for(String s : arr) {
            String tail = s.substring(s.length() - 1, s.length());
            if(list.contains(tail)) {
                count--;
                list.remove((String) tail);
            }
        }
        return count == 1 ? 1 : -1;
    }


}
