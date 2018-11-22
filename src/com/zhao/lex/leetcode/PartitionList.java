package com.zhao.lex.leetcode;


/**
 * Created by qtfs on 2017/11/26.
 */
public class PartitionList {
    public static RemoveNthNodeFromEndofList.ListNode partition(RemoveNthNodeFromEndofList.ListNode head, int x) {
        RemoveNthNodeFromEndofList.ListNode leftNode = head;
        RemoveNthNodeFromEndofList.ListNode rightNode = leftNode.next;
        while(rightNode != null) {
            if(leftNode.val >= x) {
                if(rightNode.val < x) {
                    if(head.val > rightNode.val) {
                        leftNode.next = rightNode.next;
                        rightNode.next = head;
                        head = rightNode;
                    }
                    else {
                        for(RemoveNthNodeFromEndofList.ListNode node = head; node != rightNode; node = node.next) {
                            if(node.next.val >= rightNode.val) {
                                leftNode.next = rightNode.next;
                                rightNode.next = node.next;
                                node.next = rightNode;
                            }
                        }
                    }
                }
            }
            if(leftNode.next != null) {
                rightNode = leftNode.next.next;
                leftNode = leftNode.next;
            }
            else
                break;
        }
        return head;
    }
    /*
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }
*/
    public static void main(String[] args) {
        //int[] nums = new int[]{1, 2, 3, 5, 2, 3, 2, 3, 6, 7, 11 , 33, 55 ,22, 56, 23};
        int[] nums = new int[]{2, 3, 1};
        RemoveNthNodeFromEndofList.ListNode head = new RemoveNthNodeFromEndofList.ListNode(nums[0]);
        RemoveNthNodeFromEndofList.ListNode node = head;
        for(int i = 1; i < nums.length; i++) {
            node.next = new RemoveNthNodeFromEndofList.ListNode(nums[i]);
            node = node.next;
        }
        for(RemoveNthNodeFromEndofList.ListNode e : RemoveNthNodeFromEndofList.iterator(partition(head, 3)))
            System.out.print(e.val + (e.next != null ? " -> " : ""));
    }
}
