package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qtfs on 2017/11/19.
 */
public class SmallestRange {

    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] result = new int[2];
        if(nums == null) return result;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(List<Integer> num : nums) {
            min = Math.min(min, num.get(0));
            max = Math.max(max, num.get(num.size() - 1));
        }
        int length = Integer.MAX_VALUE;
        int left = min; int right = min;
        boolean marked = true;
        while(left <= max) {
            for(List<Integer> num : nums) {
                boolean temp = false;
                for(int member : num) {
                    temp = temp || (member >= left && member <= right);
                }
                marked = marked && temp;
            }
            while(!marked && right <= max) {
                right++;
                marked = true;
                for(List<Integer> num : nums) {
                    boolean temp = false;
                    for(int member : num) {
                        temp = temp || (member >= left && member <= right);
                    }
                    marked = marked && temp;
                }
            }
            if(marked) {
                if(length > right - left + 1) {
                    length = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }
            }
            left++;
        }
        return result;
    }

/*
    public static int[] smallestRange(final List<List<Integer>> list) {
        final int[][] nums = toArray(list);
        final int k = nums.length;

        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<k; i++) {
            maxValue = Math.max(maxValue, nums[i][0]);
        }

        int[] pointers = new int[k];

        int[] result = new int[2];
        int range = Integer.MAX_VALUE;

        while(true) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for(int i=0; i<k; i++) {
                int index = pointers[i];
                while(index + 1 < nums[i].length && nums[i][index + 1] <= maxValue) {
                    index++;
                }
                pointers[i] = index;
                if(nums[i][index] < minValue) {
                    minIndex = i;
                    minValue = nums[i][index];
                }
            }
            if(maxValue - minValue < range) {
                result = new int[]{minValue, maxValue};
                range = maxValue - minValue;
            }

            int minPointer = ++pointers[minIndex];
            if(minPointer == nums[minIndex].length) {
                return result;
            }
            maxValue = nums[minIndex][minPointer];
        }
    }
    private static int[][] toArray(List<List<Integer>> list) {
        int[][] nums = new int[list.size()][];
        for(int i=0; i<nums.length; i++) {
            nums[i] = new int[list.get(i).size()];
            for(int j=0; j<nums[i].length; j++) {
                nums[i][j] = list.get(i).get(j);
            }
        }
        return nums;
    }
*/
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list1 = Arrays.asList(-9183,-8441,-5863,3171,4009,4031,4158,4230,4234);
        List<Integer> list2 = Arrays.asList(10079,23120,29968,31297,31515,37077,37891,38598,38654,38794,38852,38904,38927,38934,38935);
        List<Integer> list3 = Arrays.asList(-26385,24597,41658,44425,44774,45212,45415,45421,45426,45427,45429,45432,45433,45435,45435,45436);
        List<Integer> list4 = Arrays.asList(-6914,55192,58846,64900,65942,65956,65956,65957);
        List<Integer> list5 = Arrays.asList(21418,71688,73576,74444,74817,81799,83174,84063,84346,84786,84935,85159,85238,85246,85255);
        List<Integer> list6 = Arrays.asList(28111,34551,57931,61466,62399,63038,63126,63404,64022,64312,64365,64365,64371,64373,64373,64374,64374,64375,64375,64376);
        List<Integer> list7 = Arrays.asList(-53501,5960,47475,56066,65487,82453,92519,99257,99452,99492,99585,99673,99683,99690,99692,99692,99695);
        List<Integer> list8 = Arrays.asList(-26385,24597,41658,44425,44774,45212,45415,45421,45426,45427,45429,45432,45433,45435,45435,45436);
        List<Integer> list9 = Arrays.asList(-31713,-18316,57255,65596,66673,66769,66806,66820,66824,66836,66837,66837,66838,66840,66841);
        List<Integer> list10 = Arrays.asList(-76012,12677,31462,37215,38174,38432,39006,39116,39150,39219,39313,39325,39332);
        lists.add(list1); lists.add(list2);
        lists.add(list3); lists.add(list4); lists.add(list5);
        lists.add(list6); lists.add(list7); lists.add(list8); lists.add(list9); lists.add(list10);
        for(int num : SmallestRange.smallestRange(lists))
            System.out.println(num);

    }
}
