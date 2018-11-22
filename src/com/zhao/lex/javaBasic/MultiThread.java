package com.zhao.lex.javaBasic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qtfs on 2018/6/13.
 */
public class MultiThread {
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try{
                    for(int i = 0; i < 10; i++) {
                        try{
                            System.out.print("A");
                            conditionB.signal();
                            if(i != 9)
                                conditionA.await();
                            else
                                return;
                        }catch(InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }finally{
                    lock.unlock();
                }

            }
        });
        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try{
                    for(int i = 0; i < 10; i++) {
                        try{
                            conditionB.await();
                            System.out.print("B");
                            conditionC.signal();
                        }catch(InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }finally{
                    lock.unlock();
                }

            }
        });
        Thread threadC = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try{
                    for(int i = 0; i < 10; i++) {
                        try{
                            conditionC.await();
                            System.out.println("C");
                            conditionA.signal();
                        }catch(InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }finally{
                    lock.unlock();
                }

            }
        });

        try {
            threadB.start();
            threadC.start();
            TimeUnit.MILLISECONDS.sleep(10);
            threadA.start();
        } catch (InterruptedException ex) {
        }

    }


}
