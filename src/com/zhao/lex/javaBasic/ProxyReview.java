package com.zhao.lex.javaBasic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by qtfs on 2018/9/5.
 */
public class ProxyReview {
    interface ICall{
        public void sayHi();
    }

    class ACall implements ICall {
        @Override
        public void sayHi() {
            System.out.println("A say hello");
        }
    }

   class ProxyHandler implements InvocationHandler {
        private Object proxied;

        ProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //if(method.getName().equals("sayHi"))
                System.out.println("The proxy say hello");
            return method.invoke(proxied, args);
        }
    }

    public static void main(String[] args) {
        ProxyReview review = new ProxyReview();
        ICall proxy = (ICall) Proxy.newProxyInstance(ICall.class.getClassLoader(), new Class[]{ICall.class}, review.new ProxyHandler(review.new ACall()));
        proxy.sayHi();
    }
}
