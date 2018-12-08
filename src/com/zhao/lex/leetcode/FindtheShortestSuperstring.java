package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/23.
 */
public class FindtheShortestSuperstring {
//    public String shortestSuperstring(String[] A) {
//        if(A == null || A.length == 0) return "";
//        int nums = A.length;
//        int[][] position = new int[nums][2];
//        int pos = 0;
//        StringBuilder builder = new StringBuilder();
//        builder.append(A[0]);
//        position[0][0] = 0;
//        pos += A[0].length();
//        position[0][1] = pos - 1;
//        for(int i = 1; i < nums; i++) {
//            builder.append(A[i]);
//            if(A[i].charAt(0) == A[i - 1].charAt(A[i - 1].length() - 1)) {
//                builder.deleteCharAt(pos);
//                pos--;
//            }
//            position[i][0] = pos;
//            pos += A[i].length();
//            position[i][1] = pos - 1;
//        }
//        return builder.toString();
//    }

public String shortestSuperstring(String[] A) {
    int len = A.length ;
    return shortestSuperstring(A, len);
}
    public String shortestSuperstring(String[] arr, int len) {
        while(len != 1)
        {
            int max = Integer.MIN_VALUE;
            int l = 0, r = 0;
            String resStr = null;
            for (int i = 0; i < len; i++)
            {
                for (int j = i + 1; j < len; j++)
                {
                    String string = null;
                    int res = findOverlappingPair(arr[i], arr[j], string);
                    if (max < res)
                    {
                        max = res;
                        resStr = string;
                        l = i;
                        r = j;
                    }
                }
            }
            len--;
            if (max == Integer.MIN_VALUE)
                arr[0] += arr[len];
            else
            {
                arr[l] = resStr.toString();
                arr[r] = arr[len];
            }
        }
        return arr[0];
    }

    private int findOverlappingPair(String str1, String str2, String string) {
        int max = Integer.MIN_VALUE;
        int len1 = str1.length();
        int len2 = str2.length();
        for(int i = 1; i <= Math.min(len1, len2); i++) {
            if(str1.substring(len1- i) == str2.substring(0, i)) {
                if(max < i) {
                    max = i;
                    string = str1 + str2.substring(i);
                }
            }
        }

        for(int i = 1; i <- Math.min(len1, len2); i++) {
            if(str1.substring(0, i) == str2.substring(len2 - i)) {
                if(max < i) {
                    max = i;
                    string = str2 + str1.substring(i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"catg","ctaagt","gcta","ttca","atgcatc"};
        System.out.println(new FindtheShortestSuperstring().shortestSuperstring(A));
    }
    /*
    catgatgcatcttcagctactaagt
    gctaagttcatgcatc
     */
}
