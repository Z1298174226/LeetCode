package com.zhao.lex.microsoft;

import java.lang.annotation.*;

/**
 * Created by qtfs on 2018/4/4.
 */
public class RepeatingAnnotations {

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    /*有意隐藏Filters的存在*/
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    }

    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }

    public static void main(String[] args) {

        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }

}
