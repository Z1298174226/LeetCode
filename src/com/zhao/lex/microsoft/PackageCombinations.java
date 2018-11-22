package com.zhao.lex.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by qtfs on 2018/4/19.
 */
public class PackageCombinations {
    public static List<List<Integer>> combinationSum(int target, int num, int[][] combinations) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(lists, list, num, 0, target, combinations);
        for(List<Integer> lis : lists) {
            for(int nu: lis) {
                System.out.print(nu + " ");
            }
            System.out.println();
        }
        System.out.println(lists.size());
        return lists;
    }

    public static void dfs(List<List<Integer>> lists, List<Integer> list, int num, int index, int target, int[][] combinations) {
        if(target < 0) return;
        else if(target == 0 && list.size() == num) {
            lists.add(new ArrayList<Integer>(list));
        }
        else {
            for(int i = index; i < combinations.length; i++) {
                for(int j = combinations[i][0]; j <= combinations[i][1]; j++) {
                    int value = j;
                    list.add(j);
                    dfs(lists, list, num, i + 1, target - value, combinations);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int target = scanner.nextInt();
        int[][] combinations = new int[num][2];
        for(int i = 0; i < num; i++) {
            combinations[i][0] = scanner.nextInt();
            combinations[i][1] = scanner.nextInt();
        }
        combinationSum(target, num,  combinations);
    }
}
