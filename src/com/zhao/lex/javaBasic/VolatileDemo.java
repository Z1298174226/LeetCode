package com.zhao.lex.javaBasic;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qtfs on 2018/7/27.
 */

//验证自增操作非原子操作
public class VolatileDemo {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileDemo test = new VolatileDemo();
        CountDownLatch countDown = new CountDownLatch(10);
        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                    countDown.countDown();
                }
            }.start();
        }


        try {
            countDown.await();
            System.out.println(test.inc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
