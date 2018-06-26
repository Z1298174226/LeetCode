package com.zhao.lex.leetcode;

import java.math.BigInteger;

/**
 * Created by qtfs on 2017/12/21.
 */
public class SmallestGoodBase {
    /*
    public static String smallestGoodBase(String n) {
        int num = Integer.valueOf(n);
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
    */
    public static String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        long res = 0;
        for(int k = 60; k >= 2; k--){
            long s = 2, e = n;
            while(s < e){
                long m = s + (e - s) / 2;
                BigInteger left = BigInteger.valueOf(m);
                left = left.pow(k).subtract(BigInteger.ONE);
                BigInteger right = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
                int cmr = left.compareTo(right);
                if(cmr == 0){
                    res =  m;
                    break;
                } else if(cmr < 0){
                    s = m + 1;
                } else {
                    e = m;
                }
            }

            if(res != 0) break;
        }
        return "" + res;
    }

    public static void main(String[] args) {
        System.out.println(smallestGoodBase("4681"));
    }
}
