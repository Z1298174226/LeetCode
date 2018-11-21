package com.zhao.lex.leetcode.javaBasic.singleton;

/**
 * Created by qtfs on 2018/11/14.
 */
public class Lazy {
    public static Lazy instance;
    public static synchronized Lazy getInstance() {
        instance =  new Lazy();
        return instance;
    }
}
