package com.zhao.lex.javaBasic.sort;

import java.util.Arrays;

/**
 * Created by qtfs on 2018/12/2.
 */
public class QuickSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if(start >= end) return ;
        int j = partitionUpdate(nums, start, end);
        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int standard = nums[start];
        int i = start;
        int j = end + 1;
        while(true) {
            while(nums[++i] <= standard) {
                if(i == end)
                    break;
            }
            while(nums[--j] >= standard) {
                if(j == start)
                    break;
            }
            if(i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, start, j);
        return j;
    }

    public int partitionUpdate(int[] nums, int start, int end) {
        int standard = nums[end];
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(nums[j] < standard)
                exch(nums, j, ++i);
        }
        exch(nums, end, ++i);
        return i;
    }

    public void exch(int[] nums, int i, int j) {
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 6, 2};
        new QuickSort().sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
