package com.zhao.lex.leetcode.javaBasic;

/**
 * Created by qtfs on 2018/10/22.
 */
public class STIDemo {
    class Super {
        Super me() {
            return this;
        }
        void function() {
            System.out.println("I am super");
        }
    }
    class Suber extends Super{
        @Override
        public void function() {
            System.out.println("I am Suber");
        }
    }


    public static void main(String[] args) {
        new STIDemo().new Suber().me().function();
    }
}
