package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2019/3/25.
 */
public class SumDemo {
    public int[] twoSum(int[] arr, int num) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(num - arr[i])) {
                result[0] = map.get(num - arr[i]);
                result[1] = i;
            }
            else
                map.put(arr[i], i);
        }
        return result;
    }

    public List<List<Integer>> twoSums(int[] arr, int num) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = 0; int end = arr.length - 1;
        while(start < end) {
            if(arr[start] + arr[end] == num) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(arr[start]);
                list.add(arr[end]);
                result.add(list);
                while(start < end && arr[start] == arr[start + 1]) start++;
                while(start < end && arr[end] == arr[end - 1]) end--;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] < num) start++;
            else end--;
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] arr, int num) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < arr.length - 2; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            int start = i + 1; int end = arr.length - 1;
            while(start < end) {
                if(arr[start] + arr[end] == num - arr[i]) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(arr[start]);
                    list.add(arr[end]);
                    list.add(arr[i]);
                    result.add(list);
                    while(start < end && arr[start] == arr[start + 1]) start++;
                    while(start < end && arr[end] == arr[end - 1]) end--;
                    start++;
                    end--;
                }
                else if(arr[start] + arr[end] < num - arr[i]) start++;
                else end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        Random rand = new Random();
        for(int i = 0; i < 50; i++)
            arr[i] = rand.nextInt(50);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(new SumDemo().twoSum(arr, 30)).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(new SumDemo().twoSums(arr, 30));
        System.out.println(new SumDemo().threeSum(arr, 30));
    }
}
