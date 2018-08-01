package com.zhao.lex.leetcode.javaBasic;

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


    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Singleton.getInstance());
                }
            }.start();
        }
    }
}
