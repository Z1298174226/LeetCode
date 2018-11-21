package com.zhao.lex.leetcode;

import java.util.Stack;

/**
 * Created by qtfs on 2018/11/21.
 */
public class WhetherPushPop {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0; int j = 0;
        stack.push(pushA[i]);
        i++;
        while(true) {
            if(stack.isEmpty() && j != popA.length) return false;
            if(stack.isEmpty() && j == popA.length) return true;
            if (stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                if(i == pushA.length) return false;
                stack.push(pushA[i++]);
            }
        }
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,3,5,1,2};
        System.out.println(new WhetherPushPop().IsPopOrder(pushA, popA));
    }
}
