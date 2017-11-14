package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/10.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int k = nums.length;
        dfs(lists, list, nums, k);
        return lists;
    }
    private static void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int k) {
        if(k == 0) {
            List<Integer> newList = new ArrayList<Integer>(list);
            lists.add(newList);
            return;
        }
        else {
            for(int num : nums) {
                if(!list.contains(num)) {
                    list.add(num);
                    dfs(lists, list, nums, k - 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Permutations.permute(nums));
    }
}
