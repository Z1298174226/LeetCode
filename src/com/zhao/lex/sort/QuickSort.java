package com.zhao.lex.sort;

import java.util.Random;

/**
 * Created by qtfs on 2018/11/6.
 */
public class QuickSort {
    public void sort(int[] array, int start, int end) {
        if(start >= end) return;
        //int j = partition(array, start, end);
        int j = partitionUpdate(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);
    }

    public void shellSort(int[] array) {
        int length = array.length;
        int h = 1;
        while(h < length / 3) h = 3 * h + 1;
        while(h >= 1) {
            for(int i = h ; i < length; i++) {
                for(int j = i; j >= h && less(array, j, j - h); j -= h)
                    swap(array, j, j- h);
            }
            h /= 3;
        }
    }

    public void heapSort(int[] array) {
        int length = array.length;
        for(int i = length  / 2; i > 0; i--)
            sink(array, i, length);
        while(length > 1) {
            swapHeap(array, 1, length--);
            sink(array, 1, length);
        }
    }

    private void sink(int[] array, int i, int j) {
        int harf = j >>> 1;
        while(i <= harf) {
            int child = i << 1;
            if(child < j && lessHeap(array, child, child + 1))
                child++;
            if(lessHeap(array, i, child))
                swapHeap(array, i, child);
            i = child;
        }
    }

    private int partition(int[] array, int start, int end) {
   //     int standard = array[start];
        int i = start; int j = end + 1;
        while(true) {
            while(less(array, ++i, start))
                if(i == end) break;
            while(less(array, start, --j))
                if(j == start) break;
            if(i >= j) break;
            swap(array, i, j);
        }
        swap(array, start, j);
        return j;
    }

    private int partitionUpdate(int[] array, int start, int end) {
        int i = start - 1;
        for(int j = start; j < end ; j++) {
            if(less(array, j, end))
                swap(array, j, ++i);
        }
        swap(array, end, ++i);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void swapHeap(int[] array, int i, int j) {
        int temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }

    private boolean less(int[] array, int i, int j) {
        return array[i] < array[j];
    }

    private boolean lessHeap(int[] array, int i, int j) {
        return array[i - 1] < array[j - 1];
    }

    public static void main(String[] args) {
        System.out.println((int)Math.ceil(Math.log(99) / Math.log(10)));
        System.out.println((int)Math.floor(Math.log(99) / Math.log(10)));
        System.out.println((int)Math.pow((double)100, (double)4));
        int[] array = new int[6];
        for(int i = 0; i < 6; i++)
            array[i] = new Random().nextInt(1000);
     //   new QuickSort().sort(array, 0, array.length - 1);
   //     new QuickSort().shellSort(array);
        new QuickSort().heapSort(array);
        for(int i : array)
            System.out.print(i + " ");
    }
}
