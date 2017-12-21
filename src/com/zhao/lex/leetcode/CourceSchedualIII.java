package com.zhao.lex.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by qtfs on 2017/11/14.
 */
public class CourceSchedualIII {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c:courses)
        {
            time += c[0];
            pq.add(c[0]);
            if (time > c[1]) time -= pq.poll();
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] cources = new int[][]{{100, 200}, {2000, 3000}, {200, 1300}, {1000, 1400}, {2000, 3300}};
        System.out.println(scheduleCourse(cources));
    }
}
