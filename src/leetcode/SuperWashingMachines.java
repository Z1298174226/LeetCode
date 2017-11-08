package leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/5.
 */
public class SuperWashingMachines {
    /*
    public static int nthUglyNumber(int n) {
        int[] dp = new int[1700];
        dp[1] = 1;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        map.put(1, true);
        for(int i = 2; i <= n; i++) {
            int next = dp[i - 1] + 1;
            while(!dfs(next, map))
                next++;
            dp[i] = next;
        }
        return dp[n];
    }

    private static boolean dfs(int n, Map<Integer, Boolean> map) {
        if(map.containsKey(n)) return map.get(n);
        int[] div = new int[]{2, 3, 5};
        boolean flag = false;
        for(int d : div) {
            boolean temp = (n % d == 0);
            if(temp == false)
                continue;
            int res = n / d;
            flag = temp && dfs(res, map);
            if(res == 1)
                break;
        }
        map.put(n, flag);
        return flag;
    }
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[1700];
        dp[1] = 1;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        map.put(1, true);
        List<Integer> list = new ArrayList<Integer>();
        list.add(0,2);
        list.add(0, 3);
        list.add(0, 5);
        for(int i = 2; i <= n; i++) {
            int next = dp[i - 1] + 1;
            while(!dfs(next, map, list))
                next++;
            dp[i] = next;

        }
        return dp[n];
    }

    private static boolean dfs(int n, Map<Integer, Boolean> map, List<Integer> list) {
        if(map.containsKey(n)) return map.get(n);
        boolean flag = false;
        for(int d : list) {
            boolean temp = (n % d == 0);
            if(temp == false)
                continue;
            int res = n / d;
            flag = temp && dfs(res, map, list);
            if(res == 1)
                break;
        }
        if(flag == true)
            list.add(0, n);
        map.put(n, flag);
        return flag;
    }
    /*
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }

        return ugly[n-1];
    }
     */

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 300; i++)
            System.out.println(SuperWashingMachines.nthUglyNumber(i));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
