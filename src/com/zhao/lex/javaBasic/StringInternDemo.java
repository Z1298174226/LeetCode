package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2018/9/8.
 */
public class StringInternDemo {
    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = new Integer(100);
        System.out.println(i1 == i3);
        Boolean b = true;
        Boolean c = new Boolean(true);
        System.out.println(b == c);

    }
}
