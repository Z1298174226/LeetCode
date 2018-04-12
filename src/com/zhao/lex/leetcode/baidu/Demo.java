package com.zhao.lex.leetcode.baidu;

/**
 * Created by qtfs on 2018/4/2.
 */
public class Demo {

    public static String func(int N, String s) {
        char[] array = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean[] flag = new boolean[N];
        int result = 0;
        result = strp_1(result, 0, N, array, flag);
        for(int i = 0; i < result; i++)
            builder.append('I');
        for(int i = result; i < N; i++)
            builder.append('U');
        return builder.toString();
    }
    public static int strp_1(int result, int start, int end, char[] array, boolean[] flag) {
        int N = array.length;
        if(start < 0 || end > N) return result;
        if(start >= end) return result;
        int mid = start + (end - start) / 2;
        if(array[mid] == 'n' && !flag[mid]){
            result += 1;
        }
        if(array[mid] == 'c' && !flag[mid]){
            result += 1;
            flag[mid] = true;
            if(mid - 2 >= 0 && !flag[mid - 2]) {
                if(array[mid - 2] == 'c')
                    result = strp_1(result, start, mid, array, flag);
                else {
                    result += 1;
                    flag[mid - 2] = true;
                }
            }
            if(mid - 1 >= 0 && !flag[mid - 1]) {
                if(array[mid - 1] == 'c')
                    result = strp_1(result, start, mid, array, flag);
                else {
                    result += 1;
                    flag[mid - 1] = true;
                }
            }
            if(mid + 2 < N && !flag[mid + 2]) {
             //   if (!flag[mid + 1]) {
                    if (array[mid + 2] == 'c')
                        result = strp_1(result, mid, end, array, flag);
                    else {
                        result += 1;
                        flag[mid + 2] = true;
                    }
          //      }
            }
            if(mid + 1 < N && !flag[mid + 1]) {
             //   if (!flag[mid + 1]) {
                    if (array[mid + 1] == 'c')
                        result = strp_1(result, mid, end, array, flag);
                    else {
                        result += 1;
                        flag[mid + 1] = true;
                    }
                }
          //  }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(func(8, "nnccnnnc"));
    }
}
