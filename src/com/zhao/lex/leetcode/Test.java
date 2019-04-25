package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2019/4/3.
 */
public class Test {
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(3);
//        list.add(4);
//        list.remove(0);
//        list.remove((Integer) 3);
//        System.out.println(3 % 4);
//        System.out.println(list.indexOf(4));
//    }

    public int result = 0;


    public int findPalindrome(int input1, int[] input2) {
        if(input1 == 0) return 0;
        int[][] dp = new int[input1][input1];
        for(int i = 0; i < input1; i++) {
            for(int j = 0; j <= i; j++)
                dp[j][i] = i - j + 1;
        }
        for (int i = 0; i < input1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (input2[i] == input2[j])
                        dp[j][i] = Math.min(dp[j][i], dp[j + 1][i - 1]);
                else {
                    for (int k = j; k < i; k++) {
                        //  dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                            dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
                     }
                }
            }
        }
        return dp[0][input1 - 1];
//        for (int i = 0; i < input1; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (input2[i] == input2[j])
//                    dp[j][i] = dp[j + 1][i - 1] + 2;
//                else
//                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
//                result = Math.max(result, dp[j][i]);
//            }
//        }
//        return input1 - result + 1;
    }

    public static void main(String[] args) {
        int[] input2 = new int[]{4, 1, 3, 1, 5, 7, 5, 4};
        System.out.println(new Test().findPalindrome(8, input2));
    }

//   public int function(int input1, int[] input2) {
//        List<Integer> list = new ArrayList<Integer>();
//        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
//        int[] cal = new int[input1 + 1];
//        int count1 = 0;
//        int count2 = 0;
//        for(int i = 1; i <= input1; i++) {
//            if(list.contains(input2[i])) {
//                if(map.get(input2[i]) == false) {
//                    count1++;
//                    map.put(input2[i], true);
//                }
//                else
//                    count2++;
//            }
//            list.add(input2[i]);
//        }
//        if(input1 - 2 * count1 - count2 > 0)
//            return input1 - 2 * count1 - count2 - 1;
//        else
//            return input1 - 2 * count1 - count2;
//    }


}
