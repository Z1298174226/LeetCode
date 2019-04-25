package com.zhao.lex.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2019/3/1.
 */
public class KthNumber {
    public int kthNumber(int[] nums, int k) {
        return kthNumber(nums, 0, nums.length - 1, k);
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if(start >= end) return;
        int j = partitionII(nums, start, end);
        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    private int kthNumber(int[] nums, int start, int end, int k) {
        int j = partitionII(nums, start, end);
        if(j + 1 == k) return nums[j];
        else if(j + 1 < k)
            return kthNumber(nums, j + 1, end, k);
        else
            return kthNumber(nums, start, j - 1, k);
    }



    public int partition(int[] nums, int start, int end) {
        int i = start; int j = end + 1;
        while(true) {
            while(less(nums, ++i, start))
                if(i == end) break;
            while(less(nums, start, --j))
                if(j == start) break;
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    private int partitionII(int[] nums, int start, int end) {
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(less(nums, j, end))
                swap(nums, j, ++i);
        }
        swap(nums, ++i, end);
        return i;
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[100];
        Random rand = new Random();
        for(int i = 0; i < 100; i++)
            nums[i] = rand.nextInt(1000);
        new KthNumber().sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + "   "));
        System.out.println();
        System.out.println(new KthNumber().kthNumber(nums, 10));
    }
}
