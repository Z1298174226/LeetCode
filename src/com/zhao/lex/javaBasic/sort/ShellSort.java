package com.zhao.lex.javaBasic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qtfs on 2018/12/7.
 */
public class ShellSort {
    public void shellSort(int[] array) {
        int length = array.length;
        int h = 1;
        while(h <= length / 3)
            h = 3 * h + 1;
        while(h >= 1) {
            for(int i = h; i < length; i++) {
                for(int j = i; j >= h && less(array, j, j - h); j -= h)
                    swap(array, j - h, j);
            }
            h = h / 3;
        }
    }

    private boolean less(int[] array, int i, int j) {
        return array[i] < array[j];
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[100];
        for(int i = 0; i < 100; i++)
            array[i] = rand.nextInt(200);
        ShellSort sort = new ShellSort();
        sort.shellSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }
}
