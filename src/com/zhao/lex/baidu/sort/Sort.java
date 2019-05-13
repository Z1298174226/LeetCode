package com.zhao.lex.baidu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2019/5/6.
 */
public class Sort {
    /*
    QuickSort
     */
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int start, int end) {
        if(start >= end) return;
       // int j = partition(array, start, end);
        int j = partitions(array, start, end);
        quickSort(array, start, j - 1);
        quickSort(array, j + 1, end);
    }

    public int partition(int[] array, int start, int end) {
        int i = start; int j = end + 1;
        while(true) {
            while(less(array, ++i, start))
                if(i == end) break;
            while(less(array, start, --j))
                if(j == start) break;
            if(i > j) break;
            swap(array, i, j);
        }
        swap(array, j, start);
        return j;
    }

    public int partitions(int[] array, int start, int end) {
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(less(array, j, end))
                swap(array, ++i, j);
        }
        swap(array, ++i, end);
        return i;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean less(int[] array, int i, int j) {
        return array[i] < array[j];
    }

    /*
    heapSort
     */

    public void heapSort(int[] arr) {
        int len = arr.length;
        for(int i = len / 2; i >= 1; i--)
            sink(arr, i, len);
        while(len > 1) {
            swapHeap(arr, 1, len--);
            sink(arr, 1, len);
        }
    }

    public void sink(int[] arr, int left, int right) {
        int half = right >>> 1;
        while(left <= half) {
            int child = left << 1;
            if(child + 1 <= right && lessHeap(arr, child + 1, child))
                child++;
            if(lessHeap(arr, child, left))
                swapHeap(arr, left, child);
            left = child;
        }
    }

    public boolean lessHeap(int[] arr, int i, int j) {
        return arr[i - 1] < arr[j - 1];
    }

    public void swapHeap(int[] arr, int i, int j) {
        int temp = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = temp;
    }

    /*
    mergeSort
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end - start + 1];
        for(int k = 0; k <= end - start; k++) {
            if(i > mid)
                temp[k] = arr[j++];
            else if(j > end)
                temp[k] = arr[i++];
            else {
                if(arr[i] < arr[j])
                    temp[k] = arr[i++];
                else
                    temp[k] = arr[j++];
            }
        }
        for(int k = 0; k <=end - start; k++)
             arr[start + k] = temp[k];
    }
    /*
    PopSort
     */

    public void popSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                if(j + 1 < len && less(arr, j + 1, j))
                    swap(arr, j + 1, j);
            }
        }
    }

    /*
    ShellSort
     */

    public void shellSort(int[] arr) {
        int len = arr.length;
        int h = 1;
        while(h <= len / 3) {
            h = h * 3 + 1;
        }
        while(h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && lessShell(arr, j, j - h); j -= h) {
                    swapShell(arr, j - h, j);
                }
            }
            h = h / 3;
        }

    }

    public boolean lessShell(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }

    public void swapShell(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            arr[i] = rand.nextInt(1000);
        }
        Sort sort = new Sort();
        sort.quickSort(arr);
        sort.heapSort(arr);
        sort.mergeSort(arr);
        sort.shellSort(arr);
        sort.popSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();

    }
}
