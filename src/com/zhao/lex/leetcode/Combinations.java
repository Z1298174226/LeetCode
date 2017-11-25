package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/8.
 */
public class Combinations {

//    public  static List<List<Integer>> combine(int n, int k) {
//        int[] candidates = new int[n];
//        Map<Integer, List<List<Integer>>> map = new HashMap<>();
//        for(int i = 0; i < n; i++)
//            candidates[i] = i + 1;
//        return dfs(candidates, 0, k);
//    }
//
//    private static List<List<Integer>> dfs(int[] candidates, int start, int k) {
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        for(int i = start; i < candidates.length; i++ ) {
//            if(k == 1) {
//                List<Integer> li = new ArrayList();
//                li.add(candidates[i]);
//                if(!lists.contains(li))
//                    lists.add(li);
//
//            }else {
//                List<List<Integer>> subLists = dfs(candidates, i + 1, k - 1);
//                for (List<Integer> list : subLists) {
//                    List<Integer> newList = new ArrayList(list);
//                   // newList.add(candidates[i]);
//                    if (!lists.contains(newList)) {
//                            newList.add(0, candidates[i]);
//                            lists.add(newList);
//                        }
//                }
//            }
//        }
//        return lists;
//    }

    public static void main(String[] args) {
        //List<List<Integer>> lists = Combinations.combine(20, 5);
        for(List<Integer> list : Combinations.combine(10, 4)) {
            for(int num : list)
                System.out.print(String.format("%4d", num));
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine(combs, comb, i + 1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}


}
