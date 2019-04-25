package com.zhao.lex.javaBasic.sort;

import java.util.*;

/**
 * Created by qtfs on 2019/2/26.
 */
public class SmallestKElement {
    public static void main(String[] args) {
        int[] nums = new int[1000];
        Random rand = new Random();
        for(int i = 0; i < 1000; i++)
            nums[i] = rand.nextInt(10000);
      //  new SmallestKElement().smallestKElement(nums, 200);
        //new SmallestKElement().sort(nums);
        new SmallestKElement().heapSort(nums);
        Arrays.stream(nums).forEach(x -> System.out.println(x));
    }

    public void smallestKElement(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < k; i++)
            queue.add(nums[i]);
        for(int i = k; i < 1000; i++) {
            if(queue.peek() > nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        System.out.println(queue);
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if(start >= end) return;
//        int j = partition(nums, start, end);
        int j = partitionII(nums, start, end);
        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    private int partitionII(int[] nums, int start, int end) {
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(nums[j] > nums[end])
                swap(nums, ++i, j);
        }
        swap(nums, ++i, end);
        return i;
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shellSort(int[] nums) {
        int length = nums.length;
        int h = 1;
        while(h < length / 3) h = h * 3 + 1;
        while(h >= 1) {
            for(int i = h; i < length; i++) {
                for(int j = i; j >= h && less(nums, j, j - h); j -= h)
                    swap(nums, j, j - h);
            }
            h = h / 3;
        }
    }

    public void shellSorts(int[] nums) {
        int length = nums.length;
        int h = 1;
        while(h < length / 3) h = h * 3 + 1;
        while(h >= 1) {
            for(int i = h; i < length; i++) {
                for(int j = i; j >= h && less(nums, j, j - h); j -= h)
                    swap(nums, j, j - h);
            }
            h = h / 3;
        }
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;
        int j = partitionsII(nums, start, end);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public int partitions(int[] nums, int start, int end) {
        int i = start;
        int j = end + 1;
        while(true) {
            while(less(nums, ++i, start))
                if(i == end) break;
            while(less(nums, start, --j))
                if(j == start) break;
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public int partitionsII(int[] nums, int start, int end) {
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(less(nums, j, end))
                swap(nums, ++i, j);
        }
        swap(nums, ++i, end);
        return i;
    }

    public void heapSort(int[] nums) {
        int length = nums.length;
        for(int i = length / 2; i >= 1; i--)
            sink(nums, i, length);
        while(length > 1) {
            swapHeap(nums, 1, length--);
            sink(nums, 1, length);
        }
    }

    private void sink(int[] nums, int start, int end) {
        int harf = end >>> 1;
        while(start <= harf) {
            int child = start << 1;
            if(child < end && lessHeap(nums, child + 1, child))
                child++;
            if(lessHeap(nums, child, start))
                swapHeap(nums, child, start);
            start = child;
        }
    }

    private boolean lessHeap(int[] nums, int i, int j) {
        return nums[i - 1] < nums[j - 1];
    }

    private void swapHeap(int[] nums, int i, int j) {
        int temp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = temp;
    }
}
