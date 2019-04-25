package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2019/3/29.
 */
public class FindPrime {
    public static void main(String[] args) {
       new FindPrime().findPrime(36010000);
    }

    public void findPrime(int n) {
        for(int i = 1; i <= n; i++) {
            if(isPrime(i))
                System.out.println(i);
        }
    }

    public boolean isPrime(int a) {
        boolean flag = true;
        if(a < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(a); i++) {
            if(a % i == 0)
                return false;
        }
        return flag;
    }
}
