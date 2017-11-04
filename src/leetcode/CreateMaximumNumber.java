package leetcode;

/**
 * Created by qtfs on 2017/11/4.
 */
public class CreateMaximumNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for(int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] max_1 = getMaxN(nums1, i);
            int[] max_2 = getMaxN(nums2, k - i);
            int[] current = merge(max_1, max_2);
            if(isLarger(current, 0, result, 0))
                result = current;
         }
        return result;
    }

    private static int[] getMaxN(int[] nums, int n) {
        int[] temp = new int[n];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            while(index > 0 && nums.length - i + index > n && temp[index - 1] < nums[i]) {
                index--;
            }
            if(index < n)
                temp[index++] = nums[i];
        }
        return temp;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int index1 = 0; int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            if(isLarger(nums1, index1, nums2, index2))
                temp[index1 + index2] = nums1[index1++];
            else
                temp[index1 + index2] = nums2[index2++];
        }
        while(index1 < nums1.length) {
            temp[index1 + index2] = nums1[index1++];
        }
        while(index2 < nums2.length) {
            temp[index1 + index2] = nums2[index2++];
        }
        return temp;
    }

    private static boolean isLarger(int[] nums1, int n1, int[] nums2, int n2) {
        for(; n1 < nums1.length && n2 < nums2.length; n1++, n2++) {
            if(nums1[n1] > nums2[n2])
                return true;
            else if(nums1[n1] < nums2[n2])
                return false;
        }
        return n1 != nums1.length;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{6, 7};
        int[] nums2 = new int[]{6, 0, 4};
        for(int i : CreateMaximumNumber.maxNumber(nums1, nums2, 5))
            System.out.print(" " + i);
        System.out.println();
        for(int i : CreateMaximumNumber.getMaxN(nums1, 2))
            System.out.print(" " + i);
    }
}
