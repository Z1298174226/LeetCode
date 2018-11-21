package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2018/11/6.
 */
public class KSmallest {
    public static void main(String[] args) {
       int[] input = new int[100];
        for(int i = 0; i < 100; i++)
            input[i] = new Random().nextInt(1000);
        System.out.println(new KSmallest().kSmallest(input, 50));
    }
    public List<Integer> kSmallest(int[] input, int k) {
        List<Integer> result = new ArrayList<Integer>(k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }

        });
        if(k == 0 || k > input.length) return result;
        for(int i = 0; i < k; i++)
            maxHeap.offer(input[i]);
        for(int i = k; i < input.length; i++) {
            if(maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for(int i = k - 1; i >= 0; i--)
            result.add(i, maxHeap.poll());
        return result;
    }

}
