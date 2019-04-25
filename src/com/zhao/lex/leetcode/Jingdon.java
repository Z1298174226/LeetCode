package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/13.
 */
import java.util.Scanner;
public class Jingdon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = new int[num -  1][2];
        for(int i = 0; i < num - 1; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        int count = 0;
        int[] dis = new int[num + 1];
        dis[0] = 0;
        dis[1] = 0;
        for(int i = 0; i < num - 1; i++) {
            dis[arr[i][0]] = 1 + dis[arr[i][1]];
        }
        int max = 0;
        for(int i = 1; i <= num; i++) {
            max = Math.max(max, dis[i]);
        }
        max++;
        System.out.println(max);
    }
}
