package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qtfs on 2019/2/27.
 */
public class allSubSet {
//    public List<String> allSubSet(String s) {
//        List<String> list = new ArrayList<String>();
//        int length = s.length();
//        int number = 1 << length;
//        StringBuilder builder = null;
//        for(int i = 0; i < number; i++) {
//            builder = new StringBuilder();
//            int index = i;
//            for(int j = 0; j < length; j++) {
//                if((index & 1) == 1)
//                    builder.append(s.charAt(j));
//                index = index >>> 1;
//            }
//            if(!list.contains(builder.toString()))
//                list.add(builder.toString());
//        }
//        System.out.println(list.size());
//        return list;
//    }
public int countPrimes(int n) {
    int count = 0;
    boolean flag = false;
    for(int i = 2; i <= n; i++) {
        int m = (int)Math.sqrt(i);
        flag = false;
        for(int j = 2; j <= m; j++) {
            if(i % j == 0) {
                flag = true;
                break;
            }
            if(!flag)
                count++;
        }
    }
    return count;
}

    public static void main(String[] args) {
//        System.out.println(new allSubSet().allSubSet("zhaoxudongis"));
//        System.out.println((char) ('a' + 3));

    }
}
