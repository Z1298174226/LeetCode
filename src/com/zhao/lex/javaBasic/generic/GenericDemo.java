package com.zhao.lex.javaBasic.generic;

import sun.net.www.content.text.Generic;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.lang.reflect.Method;
/**
 * Created by qtfs on 2018/11/21.
 */
public class GenericDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(40);
        //list.add("abc");
        try {
            Method method = list.getClass().getDeclaredMethod("add", Object.class);
            method.invoke(list, "abc");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        List<? super Father> l = new ArrayList();
        List<int[]> lists = new ArrayList<int[]>();
        System.out.println(lists.getClass().getTypeParameters().getClass().getName());
   //     l.add(new GenericDemo().new Father());
        l.add(new GenericDemo().new Son());

       Collections.sort(l, (x, y) -> {return 0;});


    }

    class Father{

    }
    class Son extends Father {

    }
}
