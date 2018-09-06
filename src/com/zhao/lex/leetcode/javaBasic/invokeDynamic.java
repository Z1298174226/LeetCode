package com.zhao.lex.leetcode.javaBasic;

import java.util.*;

/**
 * Created by qtfs on 2018/9/5.
 */
public class invokeDynamic {
    public static void main(String[] args) {
      List<Student> list = new ArrayList<Student>();
      for(int i = 0; i < 10; i++) {
          list.add(new invokeDynamic().new Student(new Random().nextInt(100)));
      }
      list.sort((o1, o2) -> o1.getAge() - o2.getAge());
      list.forEach((a) -> System.out.println(a.getAge()));
      Collections.sort(list);
    }

    class Student implements Comparable<Student> {

        private int age;
        public Student(int age){
            this.age = age;
        }
        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "age is :" + getAge();
        }

        @Override
        public int compareTo(Student o) {
            return getAge() - o.getAge();
        }
    }
}
