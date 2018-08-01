package com.zhao.lex.leetcode.javaBasic;

/**
 * Created by qtfs on 2018/3/28.
 */
public class FinalDemo {

    int i;
    final int j;
    static FinalDemo obj;
    public FinalDemo() {
        this.i = 1;
        this.j = 2;
    }

    public static void writer() {
        obj  = new FinalDemo();
    }


    public static void reader() {
        FinalDemo object = obj;
        int a = object.i;
        int b = object.j;
    }
    public synchronized void gunc() {

    }
    public void fun() {
        Thread thread =  new Thread(new Runnable() {
           @Override
            public void run() {
               gunc();
               writer();
           }
        });
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reader();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
           @Override
            public void run() {
               writer();
           }
        });
        thread2.start();
        thread1.start();
    }
}
