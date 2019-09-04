package com.zhao.lex.BinarySearchTree;

/**
 * Created by qtfs on 2019/5/27.
 */
public class IsPostSequence {
    public boolean isPostSequence(int[] post) {
        return isPostSequence(post, 0, post.length - 1);
    }

    public boolean isPostSequence(int[] post, int start, int end) {
        if(start >= end) return true;
        int index = start;
        for(; index < end; index++) {
            if(post[index] > post[end])
                break;
        }
        for(int i = index; i < end; i++) {
            if(post[i] < post[end]) return false;
        }
        return isPostSequence(post, start, index - 1) && isPostSequence(post, index, end - 1);
    }

    public static void main(String[] args) {
        int[] post = new int[]{1, 2, 5, 4, 2, 3};
        System.out.println(new IsPostSequence().isPostSequence(post));
    }
}
