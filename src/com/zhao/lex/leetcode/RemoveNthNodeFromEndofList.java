package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by qtfs on 2017/11/25.
 */
public class RemoveNthNodeFromEndofList {

    public static class ListNode  {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public  static Iterable<ListNode> iterator(ListNode head) {
        return new Iterable<ListNode>(){
            @Override
            public Iterator<ListNode> iterator() {
                List<ListNode> list = new ArrayList<ListNode>();
                for(ListNode i = head; i != null; i = i.next)
                    list.add(i);
                return new Iterator<ListNode>(){
                    int current = 0;
                    @Override
                    public boolean hasNext() {
                        return current < list.size();
                    }
                    @Override
                    public ListNode next() {
                        return list.get(current++);
                    }
                };
            }
        };
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rightNode = head;
        ListNode leftNode = head;
        for(int i = 0; i < n; i++) {
            if (rightNode != null)
                rightNode = rightNode.next;
            else
                throw new IllegalArgumentException("The list is not enough long!");
        }
        if(rightNode == null)
            return leftNode.next;
        while(rightNode.next != null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        leftNode.next = leftNode.next.next;
        return head;
    }

    class demo implements Cloneable {
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] nums = new int[]{1, 2, 3, 5, 2, 3, 2, 3, 6, 7, 11 , 33, 55 ,22, 56, 23};
        //int[] nums = new int[]{1, 2};
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for(int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        demo d = new RemoveNthNodeFromEndofList().new demo();
        demo dd = (demo) d.clone();
        System.out.println(d);
        System.out.println(dd);
        for(ListNode e : iterator(removeNthFromEnd(head, 4)))
            System.out.print(e.val + (e.next != null ? " -> " : ""));
    }


}
