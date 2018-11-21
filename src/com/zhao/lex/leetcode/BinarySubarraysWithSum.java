package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/15.
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        if(A == null || A.length == 0) return 0;
        int length = A.length;
        int left = 0; int right = 0;
        int count = 0;
        int sum = 0;
        while(left < length) {
            right = Math.min(left, right);
            sum = 0;
            while(right < length && sum <= S) {
                sum += A[right];
                right++;
                if(sum == S)
                    count++;
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 0, 1, 0, 1};
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(A, 2));
    }
}
