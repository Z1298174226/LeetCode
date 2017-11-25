package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        for(int i = 1; i <= n; i++) {
            if (rightNode != null)
                rightNode = rightNode.next;
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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 2, 3, 2, 3, 6, 7, 11 , 33, 55 ,22, 56, 23};
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for(int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        for(ListNode e : iterator(removeNthFromEnd(head, 6)))
            System.out.print(e.val + (e.next != null ? " -> " : ""));
    }
}
