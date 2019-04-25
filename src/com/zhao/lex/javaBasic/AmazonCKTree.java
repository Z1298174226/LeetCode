package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2019/3/29.
 */
public class AmazonCKTree {
    public static void main(String[] args) {
        System.out.println(new AmazonCKTree().getDepth(1234567890, 1));
    }

    public long getDepth(long a, long b) {
        long temp_1 = a;
        long temp_2 = b;
        long result = 0;
        if(temp_1 == 1 && temp_2 == 1) return 0;
        if(temp_1 == 1) return temp_2 - 1;
        if(temp_2 == 1) return temp_1 - 1;
        while(temp_1 != 1 && temp_2 != 1) {
            if(temp_1 < temp_2) {
                a = temp_2 - temp_1;
                temp_2 = a;
            }
            else {
                b = temp_1 - temp_2;
                temp_1 = b;
            }
            result++;
        }
        result++;
        return result;
    }
}
