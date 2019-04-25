package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/18.
 */
public class ThreeSum {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        Set<List<Integer>> lists = new HashSet<List<Integer>>();
//        List<Integer> list = new ArrayList<Integer>();
//        dfs(lists, list, 3, 0, nums);
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        for(List<Integer> li : lists) {
//            int sum = 0;
//            for(int num : li)
//                sum += num;
//            if(sum == 0)
//                result.add(li);
//        }
//        return result;
//    }
//    private static void dfs(Set<List<Integer>> lists, List<Integer> list, int k, int index, int[] nums) {
//        if(k == 0) {
//            lists.add(new ArrayList(list));
//            return;
//        }
//        for(int i = index; i < nums.length; i++) {
//            list.add(nums[i]);
//            dfs(lists, list, k - 1, i + 1, nums);
//            list.remove(list.size() - 1);
//        }
//    }

    /*
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for( int i = 0; i< nums.length;i++ ){
            map.put(nums[i],i);
        }
        for(int i = 0 ;i<nums.length;i++){
            //same as 2sum
            for(int j = i+1;j<nums.length;j++){
                int complement = -(nums[i]+nums[j]);
                //find a triple and add it to list
                if(map.containsKey(complement)&&map.get(complement)>j){
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[map.get(complement)]);
                    list.add(l);
                }
                //when nums[j] == nums[j+1],ignore nums[j+1].Because nums[i] and nums[j] can decide a triple and the triple can not repeat.
                //[1,-1,-1,0]--->[1,-1,0]
                while(j<nums.length-1&&nums[j]==nums[j+1]){
                    j++;
                }
            }
            //when nums[i] == nums[i+1],ignore nums[i+1].Because nums[i] and nums[j] can decide a triple and the triple can not repeat.
            //[1,1,-1,0]--->[1,-1,0]
            while(i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return list;
    }
    */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int num = 0 - nums[i];
                while(lo < hi) {
                    if (nums[lo] + nums[hi] == num) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < num) lo++;
                    else hi--;
                }
            }

        }
        return result;
    }
    /*
    [-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,11,-10,-4,-15,-9,-1,-1,3,4,1,8,1]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,11,-10,-4,-15,-9,-1,-1,3,4,1,8,1-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
