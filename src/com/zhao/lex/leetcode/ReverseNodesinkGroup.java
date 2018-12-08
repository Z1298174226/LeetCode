package com.zhao.lex.leetcode;

import java.util.Random;
import java.util.Stack;

/**
 * Created by qtfs on 2018/11/22.
 */
public class ReverseNodesinkGroup {
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
       }

        ListNode(ListNode node) {
            val = node.val;
            next = node.next;
        }
       @Override
       public String toString() {
           if(this == null) return "";
           StringBuilder builder = new StringBuilder();
           builder.append(val);
           ListNode temp = next;
           while(temp != null) {
                builder.append((temp != null ? " -> " : "") + temp.val);
                temp = temp.next;
            }
            return builder.toString();
       }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode point = head;
        ListNode temp = head;
        while(point != null) {
            temp = point;
            point = point.next;
            temp.next = null;
            stack.add(temp);
        }
        head = stack.pop();
        point = head;
        while(!stack.isEmpty()) {
            point.next = stack.pop();
            point = point.next;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode point = head;
        ListNode temp = null;
        ListNode last = head;
        int num = 0;
        while(point != null) {
            stack.clear();
            if(moveToNext(point, k) != null) {
                for(int i = 0; i < k; i++) {
                    temp = point;
                    point = point.next;
                    temp.next = null;
                    stack.add(temp);
                }
                num++;
                for(int i = 0; i < k; i++) {
                    if(num == 1) {
                        if(i == 0) {
                            head = stack.pop();
                            last = head;
                        }
                        else {
                            last.next = stack.pop();
                            last = last.next;
                        }
                    }
                    else {
                        last.next = stack.pop();
                        last = last.next;
                    }
                }
            }
            else {
                last.next = point;
                return head;
            }
        }
        return head;
    }

    private ListNode moveToNext(ListNode node, int k) {
        ListNode pointer = node;
        int counter = 0;
        while (pointer != null && counter < k) {
            pointer = pointer.next;
            counter++;
        }
        return pointer;
    }

    public static void main(String[] args) {
        ReverseNodesinkGroup re = new ReverseNodesinkGroup();
        ReverseNodesinkGroup.ListNode head = re.new ListNode(1);
        ReverseNodesinkGroup.ListNode node = head;
//        for(int i = 0; i < 50; i++) {
//            node.next = re.new ListNode(new Random().nextInt(100));
//            node = node.next;
//        }
        System.out.println(head);
     //   System.out.println(re.reverseList(head));
        System.out.println(re.reverseKGroup(head, 3));
    }
}
