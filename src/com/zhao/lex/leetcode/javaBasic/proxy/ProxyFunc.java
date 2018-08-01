package com.zhao.lex.leetcode.javaBasic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by qtfs on 2018/7/24.
 */
public class ProxyFunc implements InvocationHandler {
    Object proxied;

    public ProxyFunc(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if(method.getName().equals("print"))
            return "The content is : " + args[0];
//        try {
//            return method.invoke(proxied, args);
//        }catch(IllegalAccessException ex) {
//
//        }catch(InvocationTargetException ex) {
//
//        }
        return 0;
    }

    public static void main(String[] arags) {
        ProxyInterface self = new ProxyImplement();
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(self.getClass().getClassLoader(),
                new Class<?>[]{ProxyInterface.class},
                new ProxyFunc(new ProxyImplement()));
        System.out.println(proxy.print("intend!"));
        System.out.println(self.print("intend!"));
        System.out.println(proxy instanceof ProxyInterface);
        try {
            //Method method = self.getClass().getMethod("print", new Class<?>[]{String.class});
            Method  method = self.getClass().getDeclaredMethod("print", new Class<?>[] {String.class});
            try {
                System.out.println(method.invoke(self, "hello"));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
