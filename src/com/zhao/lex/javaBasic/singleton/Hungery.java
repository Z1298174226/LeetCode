package com.zhao.lex.javaBasic.singleton;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Created by qtfs on 2018/11/14.
 */
public class Hungery {
    public static Hungery instance = new Hungery();

    public static Hungery getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier c = new java.util.concurrent.CyclicBarrier(10);
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println(c.getNumberWaiting());
                    c.await();
                    System.out.println(Hungery.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        char a = '赵';
        System.out.println(a);
    }
}
