package com.zhao.lex.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qtfs on 2018/12/2.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        if(k > nums.length) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i = 0; i < nums.length; i++) {
            if(k != 0) {
                queue.add(nums[i]);
                k--;
                continue;
            }
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 0};
        long a = 2147483647;
        System.out.println(2 * a);
        System.out.println(new KthLargestElementinanArray().findKthLargest(nums, 2));
    }
}
