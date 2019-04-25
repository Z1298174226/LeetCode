package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2019/3/28.
 */
public class SubArray {

    public int getMaxResult_v0(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[] sumSub = new int[arr.length + 1];
        int result = 0;
        for (int i = 1; i <= arr.length; i++)
            sumSub[i] = sumSub[i - 1] + arr[i - 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result = Math.max(result, sumSub[j] - sumSub[i]);
            }
        }
        return result;
    }

    public int getMaxResult_v1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int result = arr[0];
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp = Math.max(temp + arr[i], arr[i]);
            result = Math.max(temp, result);
        }
        return result;
    }

    //v2和v1思路是一致的
    public int getMaxResult_v2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int temp = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (temp < 0)
                temp = 0;
            temp += arr[i];
            result = Math.max(result, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr_1 = new int[]{0, -2, 2, -1, 5};
        int[] arr_2 = new int[]{0, -2, 3, 12, -4, 7, 12, -5};
        System.out.println(new SubArray().getMaxResult_v2(arr_2));
    }
}
