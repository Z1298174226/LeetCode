package com.zhao.lex.javaBasic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2019/3/24.
 */
public class Merge {
    int[] aux;

    public void mergeSort(int[] arr) {
        if(arr == null || arr.length == 0) return;
        int length = arr.length;
        aux = new int[length];
        mergeSort(arr, 0, length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
//        for(int k = start; k <= end; k++) {
//            aux[k] = arr[k];
//        }
        for(int k = start; k <= end; k++) {
            if(i > mid) aux[k] = arr[j++];
            else if(j > end) aux[k] = arr[i++];
            else if(arr[i] > arr[j]) aux[k] = arr[j++];
            else aux[k] = arr[i++];
        }
        for(int k = start; k <= end; k++)
            arr[k] = aux[k];
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random rand = new Random();
        for(int i = 0; i <100; i++)
            arr[i] = rand.nextInt(1000);
        new Merge().mergeSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
