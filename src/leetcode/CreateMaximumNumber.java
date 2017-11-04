package leetcode;

/**
 * Created by qtfs on 2017/11/3.
 */
public class CreateMaximumNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int[] max1 = getMax(nums1, i);
            int[] max2 = getMax(nums2, k - i);
            int[] current = merge(max1, max2);
            if (isLarger(current, 0, result, 0)) {
                result = current;
            }
        }
        return result;
    }

    private static int[] getMax(int[] nums, int n) {
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (index > 0 && index + nums.length - i > n && result[index - 1] < nums[i]) {
                index--;
            }
            if (index < n) {
                result[index++] = nums[i];
            }
        }
        return result;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0;
        while (n1 < nums1.length && n2 < nums2.length) {
            if (isLarger(nums1, n1, nums2, n2)) {
                result[n1 + n2] = nums1[n1++];
            } else {
                result[n1 + n2] = nums2[n2++];
            }
        }
        while (n1 < nums1.length) {
            result[n1 + n2] = nums1[n1++];
        }
        while (n2 < nums2.length) {
            result[n1 + n2] = nums2[n2++];
        }
        return result;
    }

    private static boolean isLarger(int[] nums1, int n1, int[] nums2, int n2) {
        for (; n1 < nums1.length && n2 < nums2.length; n1++, n2++) {
            if (nums1[n1] > nums2[n2]) {
                return true;
            }
            else if (nums1[n1] < nums2[n2]) {
                return false;
            }
        }
        return n1 != nums1.length;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,6,7,1};
        int[] nums2 = new int[]{2,5,7,9};
        for(int i : CreateMaximumNumber.maxNumber(nums1, nums2, 3))
            System.out.print(" " + i);
    }

}
