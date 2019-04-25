package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/4/13.
 */
import java.util.*;

public class Jingdong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String[] dics = new String[num];
        for(int i = 0; i < num; i++)
            dics[i] = scanner.nextLine();
        String t = scanner.nextLine();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> result = dfs(map, dics, t);
        int max = 0;
        for(String s : result) {
            String[] arr = s.split(" ");
            max = Math.max(max, arr.length);
        }
        System.out.println(max);

    }

    public static List<String> dfs( Map<String, List<String>> map, String[] dics, String s) {
//        if(map.get(s) != null)
//            return map.get(s);
        List<String> result = new ArrayList<String>();
        boolean flag = false;
        for(String dic : dics) {
            if(s.startsWith(dic)) {
                flag = true;
            }
        }
        if(s.length() == 0 || !flag) {
            result.add("");
            return result;
        }
        for(String dic : dics) {
            int resultMax = 0;
            for(int i = 0; i <= s.length(); i++) {
                String str = s.substring(i);
                if (str.startsWith(dic)) {
                    List<String> subList = dfs(map, dics, str.substring(dic.length()));
                    int max = 0;
                    for(String con : subList) {
                        String[] cons = con.split(" ");
                        max = Math.max(max, cons.length);
                    }
                    if(resultMax < max) {
                        resultMax = max;
                        for (String sub : subList)
                            result.add(dic + (sub.isEmpty() ? "" : " ") + sub);
                    }
                }
            }
        }
      //  map.put(s, result);
        return result;
    }

}
