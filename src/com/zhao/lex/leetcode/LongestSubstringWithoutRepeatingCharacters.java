package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/25.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
//        int[] cnt = new int[256];
//        int result = 0;
//        Arrays.fill(cnt, 1);
//        int left = 0; int right = 0;
//        while(left < s.length()) {
//            right = Math.max(left, right);
//            while(right < s.length() && cnt[s.charAt(right)] !=  0) {
//                cnt[s.charAt(right)]--;
//                right++;
//            }
//            result = Math.max(result, right - left);
//            cnt[s.charAt(left)] = 1;
//            left++;
//        }
//        return result;
        if(s == null || s.length() == 0) return 0;
        int[] cnt = new int[256];
        Arrays.fill(cnt, 1);
        int left = 0;
        int right = 0;
        int len = 0;
        while(left < s.length()) {
            //right = Math.max(right, left);
            while(right < s.length() && cnt[s.charAt(right)] != 0) {
                cnt[s.charAt(right)]--;
                right++;
            }
            len = Math.max(len, right - left);
            cnt[s.charAt(left)]++;
            left++;
        }
        return len;
    }
    // dp, O(n)
    public static int lengthOfLongestSubstringUpdate(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int pre = -1;
        int cur = 0;
        int len = 0;
        for(int i = 0; i < arr.length; i++) {
            pre = Math.max(pre, map[arr[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[arr[i]] = i;
        }
        return len;
    }

    public static int shortestLengthTarget(int[] arr, int target) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
            if(map.get(sum - target) != null) {
                int pre = map.get(sum - target);
                len = Math.min(len, i - pre);
            }
        }
        return len;
    }

    public static int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            if(map.get(target - arr[i]) != null) {
                result[0] = map.get(target - arr[i]);
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSums(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = 0; int end = arr.length - 1;
        while(start < end) {
            if(arr[start] + arr[end] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(arr[start]);
                list.add(arr[end]);
                result.add(list);
                while(start < end && arr[start + 1] == arr[start]) start++;
                while(end > start && arr[end - 1] == arr[end]) end--;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] > target) end--;
            else start++;
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            int tar = target - arr[i];
            while(start < end) {
                if(arr[start] + arr[end] == tar) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(arr[i]);
                    list.add(arr[start]);
                    list.add(arr[end]);
                    result.add(list);
                    while(start < end && arr[start + 1] == arr[start]) start++;
                    while(end > start && arr[end - 1] == arr[end]) end--;
                    start++;
                    end--;
                }
                else if(arr[start] + arr[end] > tar) end--;
                else start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkewzhaoxudong";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringUpdate(s));
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(shortestLengthTarget(arr, 36));
        Arrays.stream(twoSum(arr, 9)).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(twoSums(arr, 14));
        System.out.println(threeSum(arr, 21));
    }
}
