package com.zhao.lex.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qtfs on 2019/4/20.
 */
public class MedianOfTwoSortedArray {
    public double medianOfTwoSortedArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1 + len2;
        if((len & 1) == 1) return medianOfTwoSortedArray(arr1, len1, arr2, len2, len / 2 + 1);
        else return (medianOfTwoSortedArray(arr1, len1, arr2, len2, len / 2) + medianOfTwoSortedArray(arr1, len1, arr2, len2, len / 2 + 1)) / 2.;
    }

    private int medianOfTwoSortedArray(int[] arr1, int len1, int[] arr2, int len2, int k) {
        if(len1 > len2) return medianOfTwoSortedArray(arr2, len2, arr1, len2, k);
        if(k == 1) return Math.min(arr1[0], arr2[0]);
        if(len1 == 0) return arr2[k - 1];
        if(len2 == 0) return arr1[k - 1];
        int pa = k >>> 1;
        int pb = k - pa;
        if(arr1[pa - 1] < arr2[pb - 1]) {
            int[] temp = new int[len1 - pa];
            for(int i = 0; i < len1 - pa; i++)
                temp[i] = arr1[pa + i];
            return medianOfTwoSortedArray(temp, len1 - pa, arr2, len2, k - pa);
        }
        else {
            int[] temp = new int[len2 - pb];
            for(int i = 0; i < len2 - pb; i++)
                temp[i] = arr2[pb + i];
            return medianOfTwoSortedArray(arr1, len1, temp, len2 - pb, k - pb);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 11, 20};
        int[] arr2 = new int[]{2, 6, 7, 10, 12};
        System.out.println(new MedianOfTwoSortedArray().medianOfTwoSortedArray(arr1, arr2));
    }
    class ListNode {
        int val;
        ListNode(int val) {
            this.val = val;
        }
        ListNode next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for(ListNode list : lists) {
            ListNode node = list;
            while(node != null) {
                list = list.next;
                node.next = null;
                queue.add(node);
                node = list;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while(!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
        }
        return result.next;
    }
}
