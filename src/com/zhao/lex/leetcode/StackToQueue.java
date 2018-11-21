package com.zhao.lex.leetcode;

import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Created by qtfs on 2018/11/21.
 */
public class StackToQueue{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty())
            return stack2.pop();
        else if(!stack1.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        else
            return stack2.pop();
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        for(int i = 0; i < 10; i++)
            queue.push(new Random().nextInt(100));
        System.out.println(queue);
    }
}
