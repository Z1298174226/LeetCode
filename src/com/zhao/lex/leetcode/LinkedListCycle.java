package com.zhao.lex.leetcode;


import com.zhao.lex.leetcode.RemoveNthNodeFromEndofList.ListNode;
/**
 * Created by qtfs on 2017/11/25.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
