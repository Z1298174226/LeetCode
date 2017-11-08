package leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/7.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return dfs(candidates, 0,target);
    }

    private static List<List<Integer>> dfs(int[] candidates, int index, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int j = index; j < candidates.length; j++) {
            int i = candidates[j];
            if (i == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                lists.add(list);
            } else if (i < target) {
                List<List<Integer>> subLists = dfs(candidates, j, target - i);
                for (List<Integer> list : subLists) {
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(0, i);
                    if(!lists.contains(newList))
                        lists.add(newList);

                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2 ,3 ,6 ,7};
        List<List<Integer>> lists = CombinationSum.combinationSum(nums, 9);
        for(List<Integer> list : lists) {
            for(int i : list)
                System.out.print(String.format("%3d", i));
            System.out.println();
        }
    }
}
