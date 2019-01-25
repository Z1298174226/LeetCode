package com.zhao.lex.javaBasic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by qtfs on 2018/7/23.
 */
public class ProxyDemo {
    interface Demo {
        String demo(String str);
    }
    static class DemoChild implements Demo {
        @Override
        public String demo(String str) {
            System.out.println("The content is: " + str);
            return "The content is : " + str;
        }
    }

    static class ProxyFunc implements InvocationHandler {
        Object proxied;
        public ProxyFunc(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("demo"))
                System.out.println("What I said is: " + args[0]);
            return method.invoke(proxied, args);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InterruptedException {
        Demo child = (Demo) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),
                new Class<?>[] {Demo.class},
                new ProxyFunc(new DemoChild()));
        child.demo("I love you!");
    }
}
