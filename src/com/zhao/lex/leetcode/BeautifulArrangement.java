package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/9.
 */
public class BeautifulArrangement {
    private int count = 0;
    public int countArrangement(int N) {
        boolean[] used = new boolean[N + 1];
        int[] pos = new int[N +1];
        dfs(1, N, used, pos);
        return count;
    }

    private void dfs(int index, int N, boolean[] used, int[] pos) {
        if(index == N + 1)
            count++;
        else {
            for(int i = 1; i <= N; i++) {
                if(used[i]) continue;
                used[i] = true;
                pos[index] = i;
                if(i % index == 0 || index % pos[index] == 0)
                    dfs(index + 1, N, used, pos);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(2));
    }
}
