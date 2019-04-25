package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2019/3/29.
 */
public class FindMedian {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 8, 6, 19, 23, 29, 88};
        System.out.println(new FindMedian().findMedian(arr));
    }

    public float findMedian(int[] arr) {
        if(arr.length % 2 != 0)
            return findMedian(arr, 0, arr.length - 1, arr.length / 2);
        else
            return (float)(findMedian(arr, 0, arr.length - 1, arr.length / 2) + findMedian(arr, 0, arr.length - 1, arr.length / 2 - 1)) / 2;
    }

    public int findMedian(int[] arr, int start, int end, int media) {
        if(start >= end) return 0;
        int j = partition(arr, start, end);
        if(j == media) return arr[j];
        else if(j > media)
            return findMedian(arr, start, j - 1,media);
        else
            return findMedian(arr, j + 1, end,media);
    }

    public int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end + 1;
        while(true) {
            while(less(arr, start, ++i))
                if(i == end) break;
            while(less(arr, --j, start))
                if(j == start) break;
            if(i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }

    public boolean less(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
