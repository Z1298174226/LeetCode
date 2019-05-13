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
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{3, 4, 5};
        System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays(arr1, arr2));
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if((len & 1) == 1)
            return (double) findKth(nums1, len1, nums2,  len2, len / 2 + 1);
        else {
            System.out.println(findKth(nums1, len1, nums2, len2, len / 2));
            System.out.println(findKth(nums1, len1, nums2, len2, len / 2 + 1));
            return (findKth(nums1, len1, nums2, len2, len / 2) + findKth(nums1, len1, nums2, len2, len / 2 + 1)) / 2.;
        }
    }

    public int findKth(int[] num1, int len1, int[] num2, int len2, int k) {
        if(len1 > len2)
            return findKth(num2, len2, num1, len1, k);
        if(len1 == 0) {
            return num2[k - 1];
        }
        if(k == 1)
            return Math.min(num1[0], num2[0]);
        int p = Math.min(k >>> 1, len1);
        int q = k - p;
        if(num1[p - 1] < num2[q - 1]) {
            int[] num1New = new int[len1 - p];
            for(int i = 0; i < len1 - p; i++)
                num1New[i] = num1[i + p];
            return findKth(num1New, len1 - p, num2, len2, k - p);
        }
        else if(num1[p - 1] > num2[q - 1]) {
            int[] num2New = new int[len2 - q];
            for(int i = 0; i < len2 - q; i++)
                num2New[i] = num2[i + q];
            return findKth(num1, len1, num2New, len2 - q, k - q);
        }
        else
            return num1[p - 1];
    }

}
