package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qtfs on 2017/11/7.
 */
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int target) {
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7,  8, 9};
        List<List<Integer>> lists = dfs(candidates, 0,target);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> list : lists) {
            if(list.size() == k)
                result.add(list);
        }
        return result;
    }
    private static List<List<Integer>> dfs(int[] candidates, int index, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int j = index; j < candidates.length; j++) {
            int i = candidates[j];
            if (i == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
               // if(!lists.contains(list))
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
        List<List<Integer>> lists = CombinationSumIII.combinationSum3(3, 14);
        for(List<Integer> list : lists) {
            for(int i : list)
                System.out.print(String.format("%3d", i));
            System.out.println();
        }
    }
}
