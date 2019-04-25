package com.zhao.lex.javaBasic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by qtfs on 2019/3/23.
 */
public class InterruptedDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(!isInterrupted()) {
                    System.out.println("t1 is running............");
                }
                System.out.println(Thread.interrupted());
                System.out.println("t1 is interrupted.........");
//                try{
//                    System.out.println("t1 started.............");
//                    TimeUnit.SECONDS.sleep(10);
//                    System.out.println("t1 continue........");
//                }catch(InterruptedException ex) {
//                    ex.printStackTrace();
//                }
            }

        };
        t1.start();

        Thread t2 = new Thread(() -> {
             try {
                 TimeUnit.SECONDS.sleep(2);
                 t1.interrupt();
                 System.out.println("t2 is running............");;
             }catch(InterruptedException ex) {

             }
        });
        t2.start();

    }
}
