package com.zhao.lex.javaBasic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2018/12/7.
 */
public class HeapSort {
    public void heapSort(int[] array) {
        int length = array.length;
        for(int i = length / 2; i > 0; i--)
            sink(array, i, length);
        while(length > 1) {
            swap(array, 1, length--);
            sink(array, 1, length);
        }
    }

    private boolean less(int[] array, int i, int j) {
        return array[i - 1] < array[j - 1];
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }

    private void sink(int[] array, int i, int j) {
        int harf = j >>> 1;
        while(i <= harf) {
            int child = i << 1;
            if(child < j && less(array, child, child + 1))
                child++;
            if(less(array, i, child))
                swap(array, i, child);
            i = child;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[100];
        for(int i = 0; i < 100; i++)
            array[i] = rand.nextInt(200);
        HeapSort sort = new HeapSort();
        sort.heapSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }

}
