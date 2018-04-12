package com.zhao.lex.leetcode.microsoft;

import java.util.Arrays;

/**
 * Created by qtfs on 2018/4/4.
 */

/*
第四题：小男孩从起点出发到学校，给所有奶茶店的距离，给所有奶茶店可以补充的能量值，
给学校的距离，给初始能量值。走1单位消耗1单位能量。问最少买几次饮料可以走到。
 */
public class MilkTea {
    public static int step(int[] distance, int[] energy, int init) {
        int number = energy.length;
        int[] buy = new int[number];
        int[] pass = new int[number];
        int count = 0;
        int initDistance = 0;
        for(int i = 0; i < number; i++) {
            buy[i] = init + energy[i] - (distance[i] - initDistance);
            pass[i] = init - (distance[i] - initDistance);
            if (pass[i] <= distance[i + 1] - distance[i]) {
                count++;
                init = buy[i];
                initDistance = distance[i];
            } else
                init = pass[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );

        int[] distance = new int[]{10, 20, 40, 100};
        int[] energy = new int[]{20, 10, 10};
        int init = 19;
        System.out.println(step(distance, energy, init));
    }
}
