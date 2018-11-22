package com.zhao.lex.javaBasic.singleton;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by qtfs on 2018/11/14.
 */
public class StaticClass {
    public static StaticClass getInstance() {
        return InnerClass.instance;
    }

    static class InnerClass {
        static final StaticClass instance = new StaticClass();
    }

    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier c = new java.util.concurrent.CyclicBarrier(10);
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(StaticClass.getInstance());
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
