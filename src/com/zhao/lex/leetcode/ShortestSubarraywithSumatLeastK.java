package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/24.
 */
public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] A, int K) {
//        int result = Integer.MAX_VALUE;
//        int length = A.length;
//        int[] sum = new int[length + 1];
//        for(int i = 1; i <= length; i++)
//            sum[i] = A[i - 1] + sum[i - 1];
//        int left = 0; int right = 0;
//        while(left < length) {
//            right = left + 1;
//            while(right <= length) {
//                int temp = sum[right]- sum[left];
//                if(temp >= K) {
//                    result = Math.min(result, right - left);
//                }
//                right++;
//            }
//            left++;
//        }
//
//        return result == Integer.MAX_VALUE ? -1 : result;
        int left = 0; int right = 0;
        int sum = 0;
        int length = A.length;
        int result = Integer.MAX_VALUE;
        boolean marked = false;
        while(left < length) {
            right = Math.max(left, right);
            while(right < length) {
                if(!marked) {
                    sum += A[right];
                    right++;
                }
                if(sum >= K) {
                    result = Math.min(result, right - left + 1);
                    break;
                }
            }
            sum -= A[left];
            marked = true;
            left++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{84,-37,32,40,95};
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(A, 167));
    }
}
