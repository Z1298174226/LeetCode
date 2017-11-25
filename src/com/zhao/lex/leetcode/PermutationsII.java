package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qtfs on 2017/11/10.
 */
public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        List<Integer> list = new ArrayList<Integer>();
//        int k = nums.length;
//        Arrays.sort(nums);
//        boolean[] marked = new boolean[k];
//        dfs(lists, list, nums, k, marked);
//        return lists;
//    }
//    private static void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int k, boolean[] marked) {
//        if(k == 0) {
//            List<Integer> newList = new ArrayList<Integer>(list);
//            lists.add(newList);
//            return;
//        }
//        else {
//            for(int i = 0; i < nums.length; i++) {
//                if(marked[nums[i]]) continue;
//                if(i > 0 && nums[i] == nums[ i -1] && !marked[i - 1]) continue;
//                list.add(nums[i]);
//                marked[nums[i]] = true;
//                dfs(lists, list, nums, k - 1, marked);
//                list.remove(list.size() - 1);
//                marked[nums[i]] = false;
//                }
//            }
//    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2};
        System.out.println(PermutationsII.permuteUnique(nums));
    }
}
