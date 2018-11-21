package com.zhao.lex.leetcode.javaBasic;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qtfs on 2018/7/29.
 */
public class Singleton {

//    private static Singleton singleton;
//    private Singleton(){
//
//    }
//    public static Singleton getInstance() {
//        if(singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }


//静态内部类单例模式

    private Singleton(){
    }
    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }
    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }

    class Comp<K> implements Comparable<K> {

        @Override
        public int compareTo(K o) {
            return 0;
        }
    }

    public <T> T[] findSmallest(T[] nums, int k) {
        T[] result = (T[]) new Object[k];
        PriorityQueue<T> queue = new PriorityQueue<T>(new Comparator<T>() {

            @Override
            public int compare(T o1, T o2) {
                return 0;
            }
        });
        return result;
    }


    public static void main(String[] args) {
//        for(int i = 0; i < 10000; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    System.out.println(Singleton.getInstance());
//                }
//            }.start();
//        }
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
        System.out.println(Integer.toHexString(-8 >>> 1));
    }
}
