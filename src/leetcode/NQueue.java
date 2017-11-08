package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/5.
 */
public class NQueue {
    public class Solution {
        int[] sol;
        public List<List<String>> solveNQueens(int n) {
            sol = new int[n];
            List<List<String>> res = new ArrayList();
            DFS(res, n, 0, 0, 0, 0);
            return res;
        }
        private void DFS(List<List<String>> res, int N, int row, int col, int d1, int d2) {
            int avl = ((1 << N) - 1) & ~(col | d1 | d2);     //availalbe positions, bitmask
            while (avl != 0) {
                int p = avl & -avl;
                avl ^= p;
                sol[row] = p;
                if (row == N - 1) {
                    List<String> list = new ArrayList();
                    for (int i = 0; i < N; i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int c = 0; c < N; c++) {
                            if ((1 << c) == sol[i]) sb.append("Q");
                            else sb.append(".");
                        }
                        list.add(sb.toString());
                    }
                    res.add(list);
                } else {
                    DFS(res, N, row + 1, col ^ p, (d1 ^ p) >> 1, (d2 ^ p) << 1);
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
