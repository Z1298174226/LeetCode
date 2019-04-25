package com.zhao.lex.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Created by qtfs on 2019/3/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        String[] s = new String[N];
        for(int i = 0; i < N; i++)
            s[i] = scanner.nextLine();
        String[] result = new Main().function(N, s);
        Arrays.stream(result).forEach(x -> System.out.println(x));
    }

    public String[] function(int N, String[] s) {
        String[] result = new String[N];
        for(int i = 0 ; i < N; i++) {
            StringBuilder builder = new StringBuilder();
            int num = 0;
            int value = 0;
            int[] cnt = new int[256];
            int length = s[i].length();
            for(int j = 0; j < length; j++) {
                cnt[s[i].charAt(j)]++;
                if(cnt[s[i].charAt(j)] == 2)
                    num++;
                if(cnt[s[i].charAt(j) ] < 3 && num < 2)
                    builder.append(s[i].charAt(j));
                if(cnt[s[i].charAt(j)] > 2 || num > 1)
                    value++;
                if(value != 0 && builder.length() + value == j + 1) {
                    if(cnt[s[i].charAt(j)] > 2)
                        num = 1;
                    if(num > 1)
                        num = 0;
                }
                if(j > 0 && s[i].charAt(j - 1) != s[i].charAt(j))
                    cnt[s[i].charAt(j - 1)] = 0;
            }
            result[i] = builder.toString();
        }
        return result;
    }

}
