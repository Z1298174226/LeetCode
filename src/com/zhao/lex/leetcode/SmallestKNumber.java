package com.zhao.lex.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by qtfs on 2018/11/21.
 */
public class SmallestKNumber {
    public int[] findSmallestKNmeber(int[] nums, int k) {
        if(nums == null || nums.length < k) return new int[]{};
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < k; i++)
            queue.add(nums[i]);
        for(int i = k; i < nums.length; i++) {
            if(nums[i] < queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        for(int i = 0; i < k; i++)
            result[i] = queue.poll();
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        for(int i = 0; i < 100; i++)
            nums[i] = new Random().nextInt(10000);
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(new SmallestKNumber().findSmallestKNmeber(nums, 6)).forEach(x -> System.out.print(x + " "));
    }
}
