package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/5.
 */
public class ShoppingOffers {
//    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        int result = 0;
//        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
//        result = dfs(price, special, needs, map);
//        return result;
//    }
//
//    public static int dfs(List<Integer> prices, List<List<Integer>> special , List<Integer> needs, Map<List<Integer>, Integer> map) {
//        if(map.containsKey(needs)) return map.get(needs);
//        int result = Integer.MAX_VALUE;
//        for(List<Integer> s : special) {
//            boolean flag = true;
//            List<Integer> copyNeeds = new ArrayList<Integer>(needs);
//            for(int i = 0; i < needs.size(); i++) {
//                copyNeeds.set(i, copyNeeds.get(i) - s.get(i));
//                if(copyNeeds.get(i) < 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) {
//                result = Math.min(result, s.get(special.size() - 1) + dfs(prices, special, copyNeeds, map));
//            }
//        }
//        int noSpecial = 0;
//        for(int i = 0; i < needs.size(); i++) {
//            noSpecial += prices.get(i) * needs.get(i);
//        }
//        result = Math.min(result, noSpecial);
//        map.put(needs, result);
//        return result;
//    }
public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    Map<List<Integer>, Integer> result = new HashMap<List<Integer>, Integer>();
    return dfs(result, needs, price, special);
}

    private int dfs(Map<List<Integer>, Integer> result, List<Integer> needs, List<Integer> price, List<List<Integer>> special) {
        if(result.containsKey(needs))
            return result.get(needs);
        int cost = Integer.MAX_VALUE;
        int costNospecial = 0;
        boolean mark = false;
        if(needs.size() == 0)
            return cost;
        for(List<Integer> spe: special) {
            List<Integer> needsCopy = new ArrayList<Integer>(needs);
            mark = true;
            for(int i = 0; i < needs.size(); i++) {
                if(needsCopy.get(i) - spe.get(i) >= 0) {
                    needsCopy.set(i, needsCopy.get(i) - spe.get(i));
                }
                else {
                    mark = false;
                    break;
                }
            }
            if(mark)
                cost = Math.min(cost, spe.get(spe.size() -  1) + dfs(result, needsCopy, price, special));
        }
        for(int i = 0; i < needs.size(); i++) {
            costNospecial += needs.get(i) * price.get(i);
        }
        cost = Math.min(cost, costNospecial);
        result.put(needs, cost);
        return cost;
    }
}
