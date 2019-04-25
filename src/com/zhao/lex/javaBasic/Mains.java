package com.zhao.lex.javaBasic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Created by qtfs on 2019/4/9.
 */
public class Mains {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 6; i <= n; i++) {
            //   list.add(i);
            dfs(result, list, n - i);
            //    list.remove(list.size() - 1);
        }
        // System.out.println(result.size() % 666666666);
        System.out.println(count);
    }

    public static void dfs(List<List<Integer>> result, List<Integer> list, int num) {
        if(num == 0) {
            count++;
            //  List<Integer> newList = new ArrayList<Integer>(list);
            //   if(!result.contains(list))
            //      result.add(newList);
        }else {
            for(int i = 1; i <= num; i++) {
                //       list.add(i);
                dfs(result, list, num - i);
                //    list.remove(list.size() - 1);
            }
        }
    }
    }
//public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    int w = scanner.nextInt();
//    int[] arr = new int[2*n];
//    for(int i = 0; i < 2*n; i++)
//        arr[i] = scanner.nextInt();
//    Arrays.sort(arr);
//    int min1 = Integer.MAX_VALUE;
//    int min2 = Integer.MAX_VALUE;
//    for(int i = 0; i < n; i++)
//        min1 = Math.min(min1, arr[i]);
//    for(int i = n; i < 2 * n; i++)
//        min2 = Math.min(min2, arr[i]);
//    double minResult = Math.min(min2, min1 * 2);
//    double result = Math.min((double)minResult * 1.5 * n, w);
//    System.out.println(String.format("%.6f", result));
//}

