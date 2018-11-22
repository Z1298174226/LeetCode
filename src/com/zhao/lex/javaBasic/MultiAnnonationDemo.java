package com.zhao.lex.javaBasic;

import java.lang.annotation.*;
import java.lang.reflect.Proxy;

/**
 * Created by qtfs on 2018/10/16.
 */
public class MultiAnnonationDemo {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {

    }

    public static void main(String[] args) {
        for(Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}
