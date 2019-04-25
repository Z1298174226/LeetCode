package com.zhao.lex.javaBasic;


import java.util.Scanner;

/**
 * Created by qtfs on 2019/3/16.
 */
public class CutWood {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        int N = Integer.valueOf(s1.split(" ")[0]);
        int M = Integer.valueOf(s1.split(" ")[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        double m = 0.0;
        for(int i = 0; i < N; i++)
            m = Math.max(m, arr[i]);
        System.out.println(String.format("%.2f", new CutWood().solve(arr, N, M, m)));
    }


    int cut(int[] arr, double mid, int N) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += (int) (arr[i] / mid);
        }
        return cnt;
    }

    //二分
    float solve(int[] arr, int N, int M, double m) {
        double l = 0, r = m;
        for (int i = 0; i < 200; i++) {
            double mid = (l + r) / 2;
            if (cut(arr, mid, N) >= M) l = mid;
            else r = mid;
        }
//        while(l < r) {
//            double mid = (l + r) / 2;
//            if (cut(arr, mid, N) >= M) l = mid + 0.0001;
//            else
//                r = mid;
//        }
        return (float)r;
    }
}
