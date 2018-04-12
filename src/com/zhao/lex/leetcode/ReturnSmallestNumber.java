package com.zhao.lex.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2018/3/26.
 */
public class ReturnSmallestNumber {

    public static long returnSmallestNumber(String s) {
        int[] cnt = new int[10];
        int[] cnt_copy = new int[10];
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            cnt[array[i] - '0']++;
            cnt_copy[array[i] - '0']++;
        }
        Arrays.sort(cnt_copy);
        for(int n : cnt)
            System.out.println(n);
        int small = cnt_copy[0];
        int small_copy = cnt_copy[1];
        int num = 0;
        for(int i = 0; i < 10; i++) {
            if (cnt[i] == small) {
                num = i;
                if (num == 0 && small_copy == small) {
                    continue;
                }
                else
                    break;
            }
        }
        if(num == 0) return (long) Math.pow(10.0, small + 1);
        else {
            while(small > -1)
                result += num * Math.pow(10.0, small--);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "12345678901234567890210123456789012345678901234567893456789";
        System.out.println(returnSmallestNumber(s));
    }
}
