package com.zhao.lex.meituan;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * Created by qtfs on 2018/3/27.
 */
public class Question4 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int jobNumber = scanner.nextInt();
        int friNumber = scanner.nextInt();
        long[] hards = new long[jobNumber];
        long[] pays = new long[jobNumber];
        long[] ability = new long[friNumber];
        Map<Long, Long> job = new HashMap<Long, Long>();
        Map<Integer, Long> fri = new HashMap<Integer, Long>();
        Map<Integer, Long> pay = new HashMap<Integer, Long>();

        for(int i = 0; i < jobNumber; i++) {
            hards[i] = scanner.nextInt();
            pays[i] = scanner.nextInt();
            job.put(hards[i], pays[i]);
        }

        for(int i = 0; i < friNumber; i++) {
            ability[i] = scanner.nextInt();
            fri.put(i, ability[i]);
            pay.put(i, (long) 0);
        }
        for(int i : fri.keySet()) {
            for(long hard : job.keySet()) {
                if(hard <= fri.get(i)) {
                    if(job.get(hard) > pay.get(i)) {
                        pay.put(i, job.get(hard));
                    }
                }
            }
        }
        for(int i : pay.keySet())
            System.out.println(pay.get(i));


    }
}
