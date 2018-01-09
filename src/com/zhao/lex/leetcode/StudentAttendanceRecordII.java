package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/1/9.
 */
public class StudentAttendanceRecordII {

    public static int checkRecord(int n) {
        int count = 0;
        String[] status = new String[]{"P", "L", "A"};
        String builder = new String();
        List<String> lists = new ArrayList<String>();
        count = dfs(status, n, count, lists, builder);
        for(String s : lists)
            System.out.println(s);
        return count;
    }

    private static int dfs(String[] status, int n, int count, List<String> lists, String builder) {
        if(n == 0) {
            count++;
            String newBuilder = new String(builder);
        //    lists.add(newBuilder);
        }
        else {
            for(String s : status) {
                if(s == "A" && builder.contains("A"))
                    continue;
                else if(s == "L" && builder.endsWith("LL"))
                    continue;
                else {
                    builder += s;
                    count = dfs(status, n - 1, count, lists, builder);
                    builder = builder.substring(0, builder.length() - 1);
                }
            }
        }
        return count;
    }

    public static int checkRecord1(int n) {
        int[] dp = { 1, 1, 0, 1, 0, 0 }; // init table for n = 1
        for (int i = 2; i <= n; i++) // updating table for n = i
            dp = new int[] { sum(dp, 0, 2), dp[0], dp[1], sum(dp, 0, 5), dp[3], dp[4] };
        return sum(dp, 0, 5);
    }

    static int sum(int[] arr, int l, int h) {
        int s = 0;
        for (int i = l; i <= h; i++)
            s = (s + arr[i]) % 1000000007;  //太扯淡了
        return s;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord1(26));
    }

}
