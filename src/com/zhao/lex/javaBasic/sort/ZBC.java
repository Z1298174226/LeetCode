package com.zhao.lex.javaBasic.sort;

/**
 * Created by qtfs on 2018/12/10.
 */
public class ZBC {


    public static void main(String[] args) {
        Father fa = new Son();
        fa.function();
    }
}

class Father {
    public void function() {
        System.out.println("I am father");
    }
}
class Son extends Father {
    @Override
    public void function() {
        System.out.println("I am son");
    }
}
