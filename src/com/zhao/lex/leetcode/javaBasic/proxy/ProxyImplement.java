package com.zhao.lex.leetcode.javaBasic.proxy;

/**
 * Created by qtfs on 2018/7/24.
 */
public class ProxyImplement implements ProxyInterface{

    @Override
    public String print(String str) {
        return "What you input is : " + str;
    }

    @Override
    public String toString() {
        return "I am a implements of the interface";
    }
}
