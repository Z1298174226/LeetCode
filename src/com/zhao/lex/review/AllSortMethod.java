package com.zhao.lex.review;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2019/4/25.
 */
public class AllSortMethod {
    int[] temp;
    public AllSortMethod(int num) {
        temp = new int[num];
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++)
            arr[i] = rand.nextInt(1000);
        AllSortMethod methods = new AllSortMethod(100);
//        methods.QuickSort(arr);
//        methods.MergeSort(arr);
//        methods.heapSort(arr);
//        methods.shellSort(arr);
        methods.popSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + "  "));
    }
/*
QuickSort
 */
    public void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    public void QuickSort(int[] arr, int start, int end) {
        if(start >= end) return;
        //int j = partition(arr, start, end);
        int j = partitionII(arr, start, end);
        QuickSort(arr, start, j - 1);
        QuickSort(arr, j + 1, end);
    }

   public int partition(int[] arr, int start, int end) {
        int i = start; int j = end + 1;
        while(true) {
            while(arr[++i] < arr[start])
                if(i == end) break;
            while(arr[--j] > arr[start])
                if(j == start) break;
            if(i > j) break;
            swap(arr, i, j);
        }
        swap(arr, j, start);
        return j;
   }

   public int partitionII(int[] arr, int start, int end) {
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(arr[j] < arr[end])
                swap(arr, ++i, j);
        }
        swap(arr, end, ++i);
        return i;
   }

   private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
   }

   /*
   MergeSort
    */
   public void MergeSort(int[] arr) {
        MergeSort(arr, 0, arr.length - 1);
   }

   public void MergeSort(int[] arr, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        MergeSort(arr, start, mid);
        MergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
   }

   public void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        for(int k = start; k <= end; k++) {
            if(i > mid) temp[k] = arr[j++];
            else if(j > end) temp[k] = arr[i++];
            else if(arr[i] < arr[j]) temp[k] = arr[i++];
            else temp[k] = arr[j++];
        }
        for(int s = start; s <= end; s++) {
            arr[s] = temp[s];
        }

   }

   /*
   Heap Sort
    */

   public void heapSort(int[] arr) {
       int len = arr.length;
       for(int i = len >>> 1; i > 0; i--)
           sink(arr, i, len);
       while(len > 1) {
           swapHeap(arr, 1, len--);
           sink(arr, 1, len);
       }
   }

   public void sink(int[] arr, int i, int j) {
       int half = j >>> 1;
       while(i <= half) {
           int child = i << 1;
           if(child < j && arr[child - 1] < arr[child])
               child++;
           if(arr[i - 1] < arr[child - 1])
               swapHeap(arr, i, child);
           i = child;
       }
   }

   public void swapHeap(int[] arr, int i, int j) {
       int temp = arr[i - 1];
       arr[i - 1] = arr[j - 1];
       arr[j - 1] = temp;
   }

   /*
   ShellSort
    */

   public void shellSort(int[] arr) {
       int len = arr.length;
       int h = 1;
       while(h < len / 3)
           h = h * 3 + 1;
       while(h >= 1) {
           for(int i = h; i < len; i++) {
               for(int j = i; j >= h && arr[j - h] > arr[j]; j -= h) {
                   swap(arr, j - h, j);
               }
           }
           h = h / 3;
       }
   }

   /*
   PopSort
    */

   public void popSort(int[] arr) {
       int len = arr.length;
       for(int i = 0; i < len; i++) {
           for(int j = 1; j < len - i; j++) {
               if(arr[j] < arr[j - 1])
                   swap(arr, j - 1, j);
           }
       }
   }
}
