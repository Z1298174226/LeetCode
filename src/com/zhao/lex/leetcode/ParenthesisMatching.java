package com.zhao.lex.leetcode;

import java.util.Stack;

/**
 * Created by qtfs on 2019/3/25.
 */
public class ParenthesisMatching {
    public int longestParemtjesis(String s) {
        int result = 0;
        int last = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                if(stack.isEmpty())
                    last = i;
                else {
                    stack.pop();
                    if (stack.isEmpty())
                        result = Math.max(result, i - last);
                    else
                        result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "()()(((()))";
        System.out.println(new ParenthesisMatching().longestParemtjesis(s));
    }
}
