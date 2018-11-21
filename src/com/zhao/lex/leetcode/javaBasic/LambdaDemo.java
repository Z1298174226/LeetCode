package com.zhao.lex.leetcode.javaBasic;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by qtfs on 2018/7/19.
 */
public class LambdaDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<Integer>();
        int b = 10;
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for(int j = 0; j < 3; j++)
                    list.add(j);
                if (System.out != null)
                    System.out.println(Thread.currentThread().getName());
                System.out.println(b);
            }, "thread -- " + i).start();
        }
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("size is " + list.size());
        list.forEach(( x) -> {
            System.out.println(x + 1);
        });
    }
}
