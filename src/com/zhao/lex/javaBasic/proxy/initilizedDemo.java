package com.zhao.lex.javaBasic.proxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Created by qtfs on 2018/7/30.
 */
public class initilizedDemo {

    public Inner innter;

    static class Inner {
        public void func() {
            System.out.println("I am a inner class");
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<initilizedDemo> init = initilizedDemo.class;
        Method m = init.getDeclaredField("innter").getClass().getDeclaredMethod("func", new Class[]{Void.class});
        m.invoke(init.getDeclaredField("innter"));
    }
}
