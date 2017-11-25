package com.zhao.lex.leetcode;

import com.zhao.lex.leetcode.RemoveNthNodeFromEndofList.ListNode;
/**
 * Created by qtfs on 2017/11/25.
 */
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
