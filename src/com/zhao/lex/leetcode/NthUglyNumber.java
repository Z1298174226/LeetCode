package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qtfs on 2018/6/27.
 */
public class NthUglyNumber {
    /*
   public static int nthUglyNumber(int n) {
       int[] dp = new int[1700];
       dp[1] = 1;
       Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
       map.put(1, true);
       for(int i = 2; i <= n; i++) {
           int next = dp[i - 1] + 1;
           while(!dfs(next, map))
               next++;
           dp[i] = next;
       }
       return dp[n];
   }

   private static boolean dfs(int n, Map<Integer, Boolean> map) {
       if(map.containsKey(n)) return map.get(n);
       int[] div = new int[]{2, 3, 5};
       boolean flag = false;
       for(int d : div) {
           boolean temp = (n % d == 0);
           if(temp == false)
               continue;
           int res = n / d;
           flag = temp && dfs(res, map);
           if(res == 1)
               break;
       }
       map.put(n, flag);
       return flag;
   }
    */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[1700];
        dp[1] = 1;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        map.put(1, true);
        List<Integer> list = new ArrayList<Integer>();
        list.add(0,2);
        list.add(0, 3);
        list.add(0, 5);
        for(int i = 2; i <= n; i++) {
            int next = dp[i - 1] + 1;
            while(!dfs(next, map, list))
                next++;
            dp[i] = next;

        }
        return dp[n];
    }

    private static boolean dfs(int n, Map<Integer, Boolean> map, List<Integer> list) {
        if(map.containsKey(n)) return map.get(n);
        boolean flag = false;
        for(int d : list) {
            boolean temp = (n % d == 0);
            if(temp == false)
                continue;
            int res = n / d;
            flag = temp && dfs(res, map, list);
            if(res == 1)
                break;
        }
        if(flag == true)
            list.add(0, n);
        map.put(n, flag);
        return flag;
    }
    /*
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }

        return ugly[n-1];
    }
     */
    public static List<Integer>  nthUgly(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        while(list.size() < n) {
            int num1 = list.get(i1) * 2;
            int num2 = list.get(i2) * 3;
            int num3 = list.get(i3) * 5;
            int min = Math.min(num1, Math.min(num2, num3));
            list.add(min);
            if(min == num1) i1++;
            if(min == num2) i2++;
            if(min == num3) i3++;
        }
        return list;
    }

    public static double Power(double base, int exponent) {
        if(exponent >= 0)
            return Powers(base, exponent);
        else {
            exponent = exponent * -1;
            return 1 / Powers(base, exponent);
        }

    }

    public static double Powers(double base, int exponent) {
        if(exponent == 0) return 1;
        return base * Power(base, exponent - 1);
    }

    public static int Fibonacci(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        int one = 1;
        int two = 1;
        int result = 0;
        for(int i = 2; i <= n; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }


    public static void main(String[] args) {
//        for(int i = 0; i < 300; i++)
//            System.out.println(NthUglyNumber.nthUglyNumber(i));
       // System.out.println(NthUglyNumber.nthUgly(100));
        System.out.println(NthUglyNumber.Fibonacci(4));
    }

    public String replaceSpace(StringBuffer str) {
        String strr = str.toString();
        String[] strs = strr.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            builder.append(strs[i]);
            if(i != strs.length - 1)
                builder.append("%20");
        }
        return builder.toString();
    }
}
