package com.zhao.lex.javaBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2019/5/6.
 */
public class Queue {
    List<Integer> num1 = new ArrayList<Integer>();
    List<Integer> num2 = new ArrayList<Integer>();
    List<Integer> num3 = new ArrayList<Integer>();
    int count = 0;
    public int Queen(int num) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] map = new int[num];
        dfs(result, num, 0, map);
        return count;
    }

    public void dfs(List<List<String>> result, int num, int row, int[] map) {
        if(row == num) {
//            List<String> list = new ArrayList<>();
//            for(int i = 0; i < num; i++) {
//                StringBuilder builder = new StringBuilder();
//                for (int col = 0; col < num; col++) {
//                    if (map[i] == col)
//                        builder.append("Q ");
//                    else
//                        builder.append(". ");
//                }
//                list.add(builder.toString());
//            }
//            result.add(list);
            count++;
        }
        else {
            for(int col = 0; col < num; col++) {
                if(num1.contains(col)) continue;
                if(num2.contains(row + col)) continue;
                if(num3.contains(row - col)) continue;
                map[row] = col;
                num1.add(col);
                num2.add(col + row);
                num3.add(row - col);
                dfs(result, num, row + 1, map);
                num1.remove(num1.size() - 1);
                num2.remove(num2.size() - 1);
                num3.remove(num3.size() - 1);
            }
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        dfs(s, wordDict, map);
        return map.get(s) != null;
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.get(s) != null)
            return map.get(s);
        List<String> list = new ArrayList<String>();
        if(s.length() == 0)
            return list;
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                list.add(word);
                list.addAll(subList);
            }
        }
        map.put(s, list);
        return list;
    }

    public static void main(String[] args) {
//       for(List<String> list : new Queue().Queen(10)) {
//           for(String s : list) {
//               System.out.println(s);
//           }
//           System.out.println("---------------------------------------");
//       }
        System.out.println(new Queue().Queen(10));
    }
}
