package com.zhao.lex.leetcode.javaBasic.singleton;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by qtfs on 2018/11/14.
 */
public class DCL {
    public volatile static  DCL instance = null;
    public static synchronized DCL getInstance () {
        if(instance == null) {
            synchronized(DCL.class) {
                if(instance == null)
                    instance = new DCL();
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier c = new java.util.concurrent.CyclicBarrier(10);
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(DCL.getInstance());
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
