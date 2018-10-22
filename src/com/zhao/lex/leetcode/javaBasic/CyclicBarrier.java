package com.zhao.lex.leetcode.javaBasic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Created by qtfs on 2018/9/13.
 */
public class CyclicBarrier {
    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier c = new java.util.concurrent.CyclicBarrier(100);
        for(int i = 0; i < 100; i++) {
            final int ii = i;
            System.out.println(c.getNumberWaiting());
            new Thread(() -> {
               try{
                   TimeUnit.SECONDS.sleep(ii);
                   c.await();
                   System.out.println(Thread.currentThread().getName());
               }catch(InterruptedException ex) {

               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
            }, "Thread - " + i).start();
        }
        Object a = new Object();
    }
}
