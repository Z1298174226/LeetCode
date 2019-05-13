package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qtfs on 2019/4/29.
 */
public class MoreThanHalf {
    public int MoreThanHalfNum_Solution(int[] array) {
        int number = find(array, 0, array.length - 1, array.length >>> 1);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                count++;
        }
        return count > (array.length >>> 1) ? number : 0;
    }

    public int find(int[] array, int start, int end, int k) {
        if (start >= end) return array[start];
        int j = partition(array, start, end);
        if (j == k) return array[j];
        else if (j < k) return find(array, j + 1, end, k);
        else return find(array, start, j - 1, k);
    }

    public int partition(int[] array, int start, int end) {
        int i = start;
        int j = end + 1;
        while (true) {
            while (less(array, ++i, start))
                if (i == end) break;
            while (less(array, start, --j))
                if (j == start) break;
            if (i > j) break;
            swap(array, i, j);
        }
        swap(array, start, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean less(int[] array, int i, int j) {
        return array[i] < array[j];
    }

    public String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : numbers)
            list.add(num);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int num : list)
            builder.append(String.valueOf(num));
        return builder.toString();
    }

    public boolean Find(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid])
                    low = mid + 1;
                else if (target < array[i][mid])
                    high = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2, 5, 2, 5, 6, 7};
        System.out.println(new MoreThanHalf().MoreThanHalfNum_Solution(arr));
        String s1 = "zhaoxudongza";
        String s2 = "zhaoxudongz";
        System.out.println(new MoreThanHalf().isSubsequence(s1, s2));
        System.out.println(new MoreThanHalf().isSebsequenceUpdate(s1, s2));
    }

    public boolean isSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int index1 = 0;
        int index2 = 0;
        while(index2 < len2) {
            index1 = s1.indexOf(s2.charAt(index2), index1);
            index2++;
            if(index1 == - 1)
                return false;
        }
        return true;
    }

    public boolean isSebsequenceUpdate(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = len1 - len2;
        boolean[][] dp = new boolean[len2 + 1][len3 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len2; i++)
            dp[i][0] = (s1.charAt(i - 1) == s2.charAt(i - 1)) && dp[i - 1][0];
        for(int i = 1; i <= len3; i++)
            dp[0][i] = true;
        for(int i = 1; i <= len2; i++) {
            for(int j = 1; j <= len3; j++) {
                dp[i][j] = dp[i][j - 1] || dp[i - 1][j] && s1.charAt(i + j - 1) == s2.charAt(i - 1);
            }
        }
        return dp[len2][len3];
    }
}
