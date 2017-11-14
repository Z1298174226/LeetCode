package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/9.
 */
public class PermutationSequenceII {
    public static String getPermutation(int n, int k) {
        int[] candidates = new int[n];
        for(int i = 0; i < n; i++)
            candidates[i] = i + 1;
        List<String> lists = new ArrayList<String>();
        String s = new String();
        dfs(lists, s, candidates, n);
        return lists.get(k - 1);
    }

    private static void dfs(List<String> lists, String s, int[] candidates, int k) {
            if(k == 0) {
                lists.add(new String(s));
                return;
            }
            for(int i = 0; i < candidates.length; i++) {
                boolean temp = true;
                for(int j = 0; j < s.length(); j++) {
                    temp = temp && (s.charAt(j) - 48 != candidates[i]);
                }
                if(temp) {
                    s += candidates[i];
                    dfs(lists, s, candidates,  k - 1);
                    s = s.substring(0, s.length() - 1);
                }
           }

    }

    public static void main(String[] args) {
        System.out.println(PermutationSequenceII.getPermutation(10,3));
    }
}
