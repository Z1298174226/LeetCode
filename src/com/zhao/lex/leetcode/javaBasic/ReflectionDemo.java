package com.zhao.lex.leetcode.javaBasic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by qtfs on 2018/7/23.
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ReflectionDemo ref = new ReflectionDemo();
        Class<?> clas = ref.getClass();
        System.out.println(clas.getClassLoader());
        for(Field field : clas.getFields()) {
            System.out.println(field.getName());
        }
        for(Method method : clas.getMethods()) {
            System.out.println(method.getName());
        }

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String fileName) throws ClassNotFoundException{
                String file = fileName.substring(fileName.lastIndexOf(".") + 1) + ".class";
                InputStream input = getClass().getResourceAsStream(file);
                if(input == null) {
                    return super.loadClass(fileName);
                }
                try {
                    byte[] bytes = new byte[input.available()];
                    input.read(bytes);
                    return defineClass(fileName, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object object = classLoader.loadClass("com.zhao.lex.leetcode.javaBasic.ReflectionDemo").newInstance();
        System.out.println(object.getClass().getClassLoader());
        System.out.println(object instanceof ReflectionDemo);
    }
    public void func() {

    }
    public void gunc() {

    }
}
