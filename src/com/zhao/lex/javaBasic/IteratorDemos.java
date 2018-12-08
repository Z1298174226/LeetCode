package com.zhao.lex.javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qtfs on 2018/11/26.
 */
public class IteratorDemos {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
//        list.add(2);
        for(int i : list) {
            list.remove(list.size() - 1);
        }
    }
}
