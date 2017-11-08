package leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/5.
 */
public class ShoppingOffers {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = 0;
        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        result = dfs(price, special, needs, map);
        return result;
    }

    public static int dfs(List<Integer> prices, List<List<Integer>> special , List<Integer> needs, Map<List<Integer>, Integer> map) {
        if(map.containsKey(needs)) return map.get(needs);
        int result = Integer.MAX_VALUE;
        for(List<Integer> s : special) {
            boolean flag = true;
            List<Integer> copyNeeds = new ArrayList<Integer>(needs);
            for(int i = 0; i < needs.size(); i++) {
                copyNeeds.set(i, copyNeeds.get(i) - s.get(i));
                if(copyNeeds.get(i) < 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result = Math.min(result, s.get(special.size() - 1) + dfs(prices, special, copyNeeds, map));
            }
        }
        int noSpecial = 0;
        for(int i = 0; i < needs.size(); i++) {
            noSpecial += prices.get(i) * needs.get(i);
        }
        result = Math.min(result, noSpecial);
        map.put(needs, result);
        return result;
    }
}
