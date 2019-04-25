package com.zhao.lex.javaBasic;

import java.lang.annotation.*;
import java.lang.reflect.Method;
/**
 * Created by qtfs on 2019/1/15.
 */
public class AnnotationDemo {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface FieldName {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Test {

    }

    @Test
    public void m1() {

    }

    @Test
    public static void m2() {

    }

    @Test
    public void m3() {
        System.out.println("I am m3");
    }

    public static void main(String[] args) {
        Class<?> clazz = AnnotationDemo.class;
        Method[] m = clazz.getDeclaredMethods();
        for(Method method : m) {
            if(method.isAnnotationPresent(Test.class)) {
                Annotation a = method.getAnnotation(Test.class);
                a.annotationType();
                System.out.println(a.annotationType());
            }
        }
    }

}