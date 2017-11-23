package leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/11/23.
 */
public class PartitiontoKEqualSumSubsets {
    //k=2(典型01背包问题）
    public static boolean canPartitionKSubsets(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0) return false;
        sum /= 2;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - nums[i]]);
            }
        }
        return dp[sum] < 10000000;
    }
    //k > 2
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % k != 0) return false;
        sum /= k;
        boolean[] marked = new boolean[nums.length];
        return canPartition(nums, marked, k, 0, 0, 0, sum);
    }

    private static boolean canPartition(int[] nums, boolean[] marked, int k, int start_index, int cur_sum, int cur_num, int target) {
        if(k == 1) return true;
        if(cur_sum == target && cur_num > 0) return canPartition(nums, marked, k - 1, 0, 0, 0, target);
        for(int i = start_index; i < nums.length; i++) {
            if(!marked[i]) {
                marked[i] = true;
                if(canPartition(nums, marked, k, i + 1, cur_sum + nums[i], cur_num++, target))
                    return true;
                marked[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(PartitiontoKEqualSumSubsets.canPartitionKSubsets(nums, 4));
        int[] nums_1 = new int[]{9, 2, 11, 34, 22, 12};
        System.out.println(PartitiontoKEqualSumSubsets.canPartitionKSubsets(nums_1));
    }
}
