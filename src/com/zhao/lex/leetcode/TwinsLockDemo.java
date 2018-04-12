package com.zhao.lex.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by qtfs on 2017/11/27.
 */
public class TwinsLockDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        Lock lock = new TwinsLock();
       // Lock lock = new ReentrantLock();
        class RunnableTask implements Runnable {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException ex) {
                }
//                Runnable subTask = new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            latch.await();
//                        }catch(InterruptedException ex) {
//                        }
//                        lock.lock();
//                        try {
//                            System.out.println(Thread.currentThread().getName());
//                            TimeUnit.SECONDS.sleep(1);
//                        } catch(InterruptedException ex) {}
//                        finally {
//                            lock.unlock();
//                        }
//                    }
//                };
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    new Thread(this).start();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                } finally {
                    lock.unlock();
                }
            }
        };
        for(int i = 0; i < 20; i++) {
            Runnable task = new RunnableTask();
            Thread thread = new Thread(task);
            thread.start();
        }
        latch.countDown();
    }
}
