package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/14.
 */
public class TrappingRainWater {
//    public int trap(int[] height) {
//        if(height == null || height.length == 0) return 0;
//        int length = height.length;
//        int left = 0; int right = 0;
//        int result = 0; int copyResult = 0;
//        boolean marked = false;
//        while(left < length) {
//            if(height[left] == 0) {
//                left++;
//                continue;
//            }
//            marked = false;
//            copyResult = result;
//            right = left;
//            while(right < length) {
//                if(height[left] <= height[right] && right - left > 1) {
//                    marked = true;
//                    break;
//                }
//                result += height[left] - height[right];
//                right++;
//            }
//            if(!marked) {
//                result = copyResult;
//                left++;
//                continue;
//            }
//            left = right;
//        }
//        return copyResult;
//    }
    public int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int result = 0;
        left[0] = height[0];
        right[length - 1] = height[length - 1];
        for(int i = 1; i < length; i++)
            left[i] = Math.max(height[i], left[i - 1]);
        for(int i = length - 2; i >= 0; i--)
            right[i] = Math.max(height[i], right[i + 1]);
        for(int i = 0; i < length; i++)
            result += Math.min(left[i], right[i]) - height[i];
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 1, 2, 3};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
