package com.zhao.lex.javaBasic;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;
/**
 * Created by qtfs on 2019/3/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int[] result = new Main().function(arr, n, k);
        Arrays.stream(result).forEach(x -> System.out.println(x));
    }
    public int[] function(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int index = 0;
        int[] result = new int[k];
        int temp = 0;
        boolean flag = false;
        for(int i = 0; i < k; i++) {
            flag = false;
            for(int j = index; j < n; j++) {
                while(arr[j] == 0)
                    index++;
                if(index == n) {
                    temp = 0;
                    break;
                }
                if(!flag) {
                    temp = arr[index];
                    flag = true;
                }
                arr[j] = arr[j] - temp;
            }
            result[i] = index >= n ? 0 : temp;
            index++;
        }
        return result;
    }

}
