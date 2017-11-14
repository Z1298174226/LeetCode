package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qtfs on 2017/11/13.
 */
public class SubSetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int k = 0; k <= nums.length; k++)
            dfs(nums, k, 0, result, list);
        return result;
    }

    private static void dfs(int[] nums, int k, int index, List<List<Integer>> lists, List<Integer> list) {
        if(index < 0 || index > nums.length) return;
        if(k == 0) {
            if(!lists.contains(list))
                lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, k - 1, i + 1, lists, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 7, 9, 11, 3, 3, 6, 7, 7};
        for(List<Integer> list : SubSetsII.subsetsWithDup(nums)) {
            for(int num : list) {
                System.out.print(String.format("%3d", num));
            }
            System.out.println();
        }
    }
}
