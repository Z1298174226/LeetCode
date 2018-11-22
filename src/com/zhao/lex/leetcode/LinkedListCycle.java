package com.zhao.lex.leetcode;


/**
 * Created by qtfs on 2017/11/25.
 */
public class LinkedListCycle {
    public boolean hasCycle(RemoveNthNodeFromEndofList.ListNode head) {
        if(head==null) return false;
        RemoveNthNodeFromEndofList.ListNode walker = head;
        RemoveNthNodeFromEndofList.ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
