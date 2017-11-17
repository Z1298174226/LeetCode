package leetcode;

/**
 * Created by qtfs on 2017/11/1.
 */
public class LongestSQ {
    //程序都有很不严密的地方
    public static int findLongestSQ(int[] Q) {
        int[] B = new int[Q.length];
        int len = 1;
        B[len] = Q[0];
        for(int i = 1; i < Q.length; i++) {
            int pos = help(B, 1, len, Q[i]);
            B[pos] = Q[i];
            len = Math.max(len, pos);
        }
        return len;
    }

    private static int help(int[] B, int start, int end, int value) {
        if(B[end] < value) return end + 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(B[mid] < value) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] Q = new int[]{1,1,3,2,5,3,7,1,1,4,6,34,54,2,67,99};
        System.out.println(LongestSQ.findLongestSQ(Q));
    }
}
