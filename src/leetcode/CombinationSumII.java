package leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/7.
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, 0,target);
    }

    private static List<List<Integer>> dfs(int[] candidates, int index, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int j = index; j < candidates.length; j++) {
            int i = candidates[j];
            if (i == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                if(!lists.contains(list))
                    lists.add(list);
            } else if (i < target) {
                List<List<Integer>> subLists = dfs(candidates, j + 1, target - i);
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
        int[] nums = new int[]{1, 1, 3, 5, 6, 7, 4, 8, 9};
        List<List<Integer>> lists = CombinationSumII.combinationSum2(nums, 17);
        for(List<Integer> list : lists) {
            for(int i : list)
                System.out.print(String.format("%3d", i));
            System.out.println();
        }
    }
}
