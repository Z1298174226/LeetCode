package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2018/8/29.
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int fNum = flights.length;
        int[][] fee = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(fee[i], Integer.MAX_VALUE);
        for(int i = 0; i < fNum; i++)
            fee[flights[i][0]][flights[i][1]] = flights[i][2];

        return dfs(n, fee, K, src, dst) > 1000000 ? -1 : dfs(n, fee, K, src, dst);
    }

    private int dfs(int n, int[][] fee, int K, int src, int dst) {
        if(K == 0)
            return fee[src][dst];
        int result = fee[src][dst];
        for(int i = 0; i < n; i++) {
            if(fee[src][i] < 1000000) {
                int half = dfs(n, fee, K - 1,i, dst);
                if(half > 100000) continue;
                result = Math.min(result, fee[src][i] + half);
            }
        }
        return result;
    }

    public int findCheapestPriceII(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3F3F3F3F;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = cost[dst];
        for(int i = k; i >= 0; i--){
            int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for(int[] flight : flights){
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == INF ? -1 : ans;
    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        final int INF = 0xffffff;
        int[][] dp = new int[K + 2][n];
        for(int k = 0; k <= K + 1; k++)
            Arrays.fill(dp[k], INF);
        for(int[] flight : flights)
            dp[0][flight[0]] = 0;
        for(int k = K + 1; k >= 1; k--) {
            for(int[] flight : flights) {
                dp[k][flight[1]] = Math.min(dp[k - 1][flight[0]] + flight[2], dp[k][flight[1]]);
            }
        }
        return dp[K + 1][dst] == INF ? -1 : dp[K + 1][dst];
    }
    /*
    5
[[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]
2
1
1
     */


    public static void main(String[] args) {

        int[][] flights = new int[][]{{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},{2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},{12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}};
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice1(17, flights, 13, 4, 5));
        int[][] flightss = new int[][] {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice1(5, flightss, 2, 1, 1));
    }
}
