package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/21.
 */
public class SmallestGoodBase {
    public static String smallestGoodBase(int num) {
        int result = 0;
        int i = (int) (Math.log((double) num) / Math.log(2.0));
        for(int j = i; j >= 2; j--) {
            int left = 2; int right = (int) (Math.pow((double) num, 1.0 / (j - 1))) + 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int sum = 0;
                for(int k = 0; k < j; k++)
                    sum = sum * mid + 1;
                if(sum == num) return String.valueOf(mid);
                else if(sum < num) left = mid + 1;
                else right = mid;
            }
        }
        return String.valueOf(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(smallestGoodBase(341));
    }
}
