package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/25.
 */
public class RemoveLinkedListElements {

    public static RemoveNthNodeFromEndofList.ListNode removeElements(RemoveNthNodeFromEndofList.ListNode head, int val) {
        if(head == null) return null;
        RemoveNthNodeFromEndofList.ListNode leftNode = head;
        RemoveNthNodeFromEndofList.ListNode rightNode = head;
        while (rightNode != null) {
            if(rightNode.val == val) {
                if(rightNode == head)
                    head = head.next;
                else {
                    leftNode.next = rightNode.next;
                    rightNode = rightNode.next;
                }
            }
            else {
                leftNode = rightNode;
                rightNode = rightNode.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 3, 5, 2, 3, 2, 3, 6, 7, 11 , 33, 55 ,22, 2, 56, 23};
        RemoveNthNodeFromEndofList.ListNode head = new RemoveNthNodeFromEndofList.ListNode(nums[0]);
        RemoveNthNodeFromEndofList.ListNode node = head;
        for(int i = 1; i < nums.length; i++) {
            node.next = new RemoveNthNodeFromEndofList.ListNode(nums[i]);
            node = node.next;
        }
        for(RemoveNthNodeFromEndofList.ListNode e : RemoveNthNodeFromEndofList.iterator(removeElements(head, 2)))
            System.out.print(e.val + (e.next != null ? " -> " : ""));
    }
}
