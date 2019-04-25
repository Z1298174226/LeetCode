package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by qtfs on 2019/4/2.
 */
public class MergeKLinkList {

    class ListNode {
        int val;

        ListNode(int val) {
            this.val = val;
        }

        ListNode next;
    }

    private static Comparator<ListNode> comp = new Comparator<ListNode>() {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            // TODO Auto-generated method stub
            return o1.val - o2.val;
        }
    };

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0 || lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), comp);
        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            while (node != null) {
                ListNode temp = node;
                node = node.next;
                temp.next = null;
                queue.add(temp);
            }
        }
        ListNode result = new MergeKLinkList().new ListNode(-1);
        ListNode t = result;
        while (!queue.isEmpty()) {
            t.next = queue.poll();
            t = t.next;
        }
        return result.next;
    }


}
