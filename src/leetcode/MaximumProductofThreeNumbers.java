package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/16.
 */
public class MaximumProductofThreeNumbers {

//    public static int maximumProduct(int[] nums) {
//        int result = Integer.MIN_VALUE;
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        List<Integer> list = new ArrayList<Integer>();
//       dfs(lists, list, nums, 3, 0, result);
//       for(List<Integer> li : lists) {
//           int product = 1;
//           for(int num : li) {
//               product *= num;
//           }
//           result = Math.max(result, product);
//       }
//        return result;
//    }
//
//    private static void  dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int k, int index, int result) {
//        if(k == 0) {
//           lists.add(new ArrayList(list));
//           return;
//        }
//        for(int j = index; j < nums.length; j++) {
//            list.add(nums[j]);
//            dfs(lists, list, nums, k - 1, j + 1, result);
//            list.remove(list.size() - 1);
//        }
//    }
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE; int max2 = Integer.MIN_VALUE; int max3 = Integer.MIN_VALUE; int min1 = Integer.MAX_VALUE; int min2 = Integer.MAX_VALUE;
       // int max1 = nums[0]; int max2 = nums[0]; int max3 = nums[0]; int min1 = nums[0]; int min2 = nums[0];
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if(nums[i] > max3) {
                max3 = nums[i];
            }
            if(nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return Math.max(max1*max2*max3, max1*min1*min2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3};
        System.out.println(MaximumProductofThreeNumbers.maximumProduct(nums));
    }
}
