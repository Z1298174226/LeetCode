package com.zhao.lex.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qtfs on 2018/11/27.
 */
public class KthSmallestElementinaSortedMatrix {
//    public int kthSmallest(int[][] matrix, int k) {
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
//        int row = matrix.length; int col = matrix[0].length;
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        int rem = k / row;
//        int mer = k % row;
//        int number = k - row * rem;
//        if(number == 0) return rem == col ? matrix[row - mer - 1][rem - 1] : Math.min(matrix[row - mer - 1][rem - 1], matrix[0][rem]);
//        for(int i = 0; i < row; i++) {
//            for(int j = 0; j < col; j++) {
//                if(i <= mer && j < rem) continue;
//                if(number > 0) {
//                    queue.add(matrix[i][j]);
//                    number--;
//                }
//                else {
//                    if(queue.peek() > matrix[i][j]) {
//                        queue.poll();
//                        queue.add(matrix[i][j]);
//                    }
//                }
//            }
//        }
//        return queue.poll();
//    }
public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int count = getLessEqual(matrix, mid);
        if (count < k) lo = mid + 1;
        else hi = mid - 1;
    }
    return lo;
}

    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 3}};
        System.out.println(new KthSmallestElementinaSortedMatrix().kthSmallest(matrix, 3));
    }

}
