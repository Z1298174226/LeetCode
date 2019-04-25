package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/12/24.
 */

//Tow Pointer
public class LongestConsecutiveSequence {
//    public static int longestConsecutive(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        Arrays.sort(nums);
//        int left = nums[0];
//        int right = nums[0];
//        int sum = 1;
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i] == nums[i+1] - 1){
//                right = nums[i+1];
//            }else if(nums[i] == nums[i+1]) {
//                continue;
//            } else {
//                sum = (sum > (right - left + 1) ? sum : (right - left + 1));
//                left = nums[i+1];
//            }
//        }
//        sum = (sum > (right - left + 1) ? sum : (right - left + 1));
//        return sum;
//    }
//
//    public static int longestConsecturiveSequenceII(int[] nums) {
//        int result = 0;
//        Arrays.sort(nums);
//        int[] newNums = new int[nums.length];
//        newNums[0] = nums[0];
//        int cnt = 1;
//        for(int i = 1; i < nums.length; i++) {
//            if(nums[i] != nums[i - 1])
//                newNums[cnt++] = nums[i];
//        }
//        int left = 0; int right = 0;
//        while(left < newNums.length) {
//            int compare = newNums[left] - 1;
//            right = Math.min(left, right);
//            while(right < newNums.length && newNums[right] - compare == 1) {
//                compare = newNums[right];
//                right++;
//            }
//            if(right <= newNums.length) {
//                result = Math.max(result, right - left);
//            }
//            left++;
//        }
//        return result;
//    }
//
//    public static int longestConsecutiveIII(int[] nums) {
//        if(nums.length < 2){
//            return nums.length;
//        }
//        Arrays.sort(nums);
//        int cur=0,max=0,count=1;
//        for(int i=1; i<nums.length; i++){
//            if(nums[cur]+1 == nums[i]){
//                cur=i;
//                count++;
//            }
//            else if(nums[cur] != nums[i]){
//                max=Math.max(max,count);
//                count=1;
//                cur=i;
//            }
//        }
//        max=Math.max(max,count);
//        return max;
//    }
public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
    Map<Integer, TreeSet<Integer>> result = new HashMap<Integer, TreeSet<Integer>>();
    int length = 0;

    for(int num : nums)
        parents.put(num, num);
    for(int num : nums) {
        if(parents.containsKey(num - 1)) {
            int parent = find(parents, parents.get(num - 1));
            parents.put(num, parent);
        }
    }

    for(int num : nums) {
        int p = find(parents, num);
        if(!result.containsKey(p))
            result.put(p, new TreeSet<Integer>());
        result.get(p).add(num);
    }
    for(int key : result.keySet()) {
        length = Math.max(length, result.get(key).size());
    }
    return length;

}

    private int find(Map<Integer, Integer> parents, int num) {
        return (parents.get(num) == num) ?  num : find(parents, parents.get(num));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }
}
