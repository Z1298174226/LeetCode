package com.zhao.lex.leetcode.javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by qtfs on 2018/7/29.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        String s = null;
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < 100; i++)
            list.add(random.nextInt(100));
        list.stream().filter((x) -> x > 10).sorted((x, y) -> x - y).map(Integer::longValue).map(Long::doubleValue).forEach(x -> System.out.println(x));
        Optional<String> opt = Optional.ofNullable(s);
//        System.out.println(s.toUpperCase());
//        System.out.println(s);
      //  opt.get().charAt(0);
       // System.out.println(opt);
        System.out.println(opt.map(String :: toUpperCase).map(String :: toLowerCase).orElse(null));
      //  s.charAt(0);
     //   System.out.println(opt.get());
    }
}
