package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/14.
 */
public class FreedomTrail {
/*
    public static  int findRotateSteps(String ring, String key) {
        boolean[][] flag = new boolean[key.length()][ring.length()];
        for(int i = 0; i < key.length(); i++) {
            for(int j = 0; j < ring.length(); j++) {
                if(key.charAt(i) == ring.charAt(j))
                    flag[i][j] = true;
            }
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(flag, lists, list, 0, ring, key);
        int result = Integer.MAX_VALUE;
        for(List<Integer> li : lists) {
            int sum = 0;
            int pre = 0;
            for(int k = 0; k < li.size(); k++) {
                sum += Math.min(Math.abs(li.get(k) - pre), Math.abs(ring.length() - Math.abs(li.get(k) - pre)));
                pre = li.get(k);
            }
            result = Math.min(result, sum);
        }
        return result + key.length();
    }

    private static void dfs(boolean[][] flag, List<List<Integer>> lists, List<Integer> list, int k, String ring, String key) {
        if (k == key.length()) {
            lists.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < ring.length(); i++) {
            if (flag[k][i]) {
                list.add(i);
                dfs(flag, lists, list, k + 1, ring, key);
                list.remove(list.size() - 1);
            }
        }
    }
    */
    /*
    public class Solution {
    */
    public static int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        return dp[0][0] + m;
    }

    /*
}
     */

/*
    private static Map<String, Map<Integer, Integer>> memo;

    public static int findRotateSteps(String ring, String key) {
        memo = new HashMap<>();
        return dfs(ring, key, 0);
    }

    private static int findPos(String ring, char ch){ // find first occurrence clockwise
        return ring.indexOf(ch);
    }

    private static int findBackPos(String ring, char ch){ //find first occurrence  anti-clockwise
        if(ring.charAt(0) == ch) return 0;
        for(int i = ring.length()-1;i>0;i--){
            if(ring.charAt(i) == ch) return i;
        }
        return 0;
    }

    private static int dfs(String ring, String key, int i){
        if(i == key.length()) return 0;
        int res = 0;
        char ch = key.charAt(i);
        if(memo.containsKey(ring) && memo.get(ring).containsKey(i)) return memo.get(ring).get(i);
        int f = findPos(ring, ch);
        int b = findBackPos(ring, ch);
        int forward = 1 + f + dfs(ring.substring(f)+ring.substring(0, f), key, i+1);
        int back = 1+ring.length()-b + dfs(ring.substring(b)+ring.substring(0, b),key, i+1);
        res = Math.min(forward, back);
        Map<Integer, Integer> ans = memo.getOrDefault(ring, new HashMap<>());
        ans.put(i, res);
        memo.put(ring, ans);
        return res;
    }
*/
    /*
    "caotmcaataijjxi"
"oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"
     */
    public static void main(String[] args) {
        String ring = "caotmcaataijjxi";
        String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        System.out.println(FreedomTrail.findRotateSteps(ring, key));
    }
}
