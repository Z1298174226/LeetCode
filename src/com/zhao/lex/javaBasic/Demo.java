package com.zhao.lex.javaBasic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by qtfs on 2018/11/7.
 */
public  class Demo {
    static int[] b = new int[10000000];
    public static void main(String[] args) throws IOException {
        String s = "zhaoxudong";
        char[] c = s.toCharArray();
        System.out.println(c[1] > 'a');
        System.out.println((int) c[1]);
    }

}