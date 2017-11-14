package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qtfs on 2017/11/10.
 */
public class PermutationSequence {
    public static List<String> getPermutation(int n, int k) {
        int[] candidates = new int[n];
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            candidates[i] = i + 1;
        return dfs(candidates, 0, n, map);//.get(k - 1);
    }

    private static List<String> dfs(int[] candidates, int start, int k, Map<Integer, List<String>> map) {
        if(map.containsKey(k)) return map.get(k);
        List<String> lists = new ArrayList<String>();
        for(int i = start; i < candidates.length; i++ ) {
            if(k == 1) {
                String builder = new String();
                builder += candidates[i];
                if(!lists.contains(builder))
                    lists.add(builder);

            }else {
                List<String> subLists = dfs(candidates, i, k - 1, map);
                for (String s : subLists) {
                    String newBuilder = new String(s);
                    if (!lists.contains(newBuilder)) {
                        boolean temp = true;
                        for(int j = 0; j < newBuilder.length(); j++) {
                            temp = temp && ((int)newBuilder.charAt(j) - 48 != candidates[i]);
                        }
                        if(temp) {
                            newBuilder = candidates[i] + newBuilder;
                            lists.add(newBuilder);
                        }
                    }
                }
            }
        }
        map.put(k, lists);
        return lists;
    }
    public static void main(String[] args) {
        System.out.println(PermutationSequence.getPermutation(9,3));
    }

}
