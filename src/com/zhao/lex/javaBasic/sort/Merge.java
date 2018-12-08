package com.zhao.lex.javaBasic.sort;

import java.util.Arrays;

/**
 * Created by qtfs on 2018/12/6.
 */
public class Merge {
    int[] aux;

    public void sort(int[] array) {
        int length = array.length;
        aux = new int[length];
        sort(0, length - 1, array);
    }

    public void sort(int lo, int hi, int[] array) {
        if(lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(lo, mid, array);
        sort(mid + 1, hi, array);
        merge(array, lo, mid, hi);
    }

    public void sortUpdate(int[] array) {
        int length = array.length;
        aux = new int[length];
        for(int i = 1; i < length; i = 2 * i) {
            for(int j = 0; j < length - i; j += 2 * i)
                merge(array, j, i + j - 1, Math.min(j + 2 * i - 1, length - 1));
        }
    }

    private void merge(int[] array, int lo, int mid, int hi) {
         int i = lo;
         int j = mid + 1;
         for(int k = lo; k <= hi; k++)
             aux[k] = array[k];
         for(int k = lo; k <= hi; k++) {
             if(i > mid) aux[k] = array[j++];
             else if(j > hi) aux[k] = array[i++];
             else if(less(array, i, j)) aux[k] = array[i++];
             else aux[k] = array[j++];
         }
    }

    private boolean less(int[] array, int i , int j) {
        return array[i] < array[j];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 6, 4, 8};
        Merge merge = new Merge();
      //  merge.sort(array);
        merge.sortUpdate(array);
        Arrays.stream(merge.aux).forEach(x -> System.out.print(x + " "));
    }
}
