package com.zhao.lex.gc;


import org.junit.Test;
/**
 * Created by qtfs on 2018/3/29.
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];
@Test
    public void test() {
    try {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
    }finally {
        System.gc();
    }
    }
}

