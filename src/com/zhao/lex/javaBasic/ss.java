package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2019/1/10.
 */
public class ss {
    static class Father{
        int a;
        int b;
        static int c;
        Father() {
            a = 1;
            b = 2;
            c = 3;
        }
        static {
            c = 3;
        }
    }
    static class Son extends Father {
        static {
            c = 4;
        }

    }

    public static void main(String[] args) {
        new Son();
    }
}
