package leetcode;

/**
 * Created by qtfs on 2017/11/1.
 */
public class MaxSubstring {
    public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        return findMaxSubstring(A, B, A.length, B.length, dp);
    }
    private static int findMaxSubstring(int[] A, int[] B, int index_1, int index_2, int[][] dp) {
        if(dp[index_1][index_2] != 0)
            return dp[index_1][index_2];
        if(index_1 == 0 || index_2 == 0)
            return 0;
        if(A[index_1 - 1] == B[index_2 - 1]) {
            int temp = findMaxSubstring(A, B, index_1 - 1, index_2 - 1, dp);
            dp[index_1][index_2] = temp + 1;
        }else {
            int temp_1 = findMaxSubstring(A, B, index_1 - 1, index_2, dp);
            int temp_2 = findMaxSubstring(A, B, index_1, index_2 - 1, dp);
            dp[index_1][index_2] = Math.max(temp_1, temp_2);
        }
        return dp[index_1][index_2];
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,0,3,4,5,2,7};
        int[] B = new int[]{8,9,1,3,0,5,6,7};
        System.out.println(MaxSubstring.findLength(A, B));
    }
}
