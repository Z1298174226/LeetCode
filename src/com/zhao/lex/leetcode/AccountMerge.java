package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/12/24.
 */
public class AccountMerge {
    public static List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> parents = new HashMap<String, String>();
        Map<String, String> owner = new HashMap<String, String>();
        Map<String, TreeSet<String>> union = new HashMap<String, TreeSet<String>>();

        for(List<String> act : acts) {
            for(int i = 1; i < act.size(); i++) {
                parents.put(act.get(i), act.get(i));
                owner.put(act.get(i), act.get(0));
            }
        }

        for(List<String> act : acts) {
            String p = find(act.get(1), parents);
            for(int i = 2; i < act.size(); i++) {
                parents.put(find(act.get(i), parents), p);
            }
        }

        for(List<String> act : acts) {
            for(int i = 1; i < act.size(); i++) {
                String p = find(act.get(i), parents);
                if(!union.containsKey(p))
                    union.put(p, new TreeSet<String>());
                union.get(p).add(act.get(i));
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(String p : union.keySet()) {
            List<String> emails = new ArrayList<String>(union.get(p));
            emails.add(0, owner.get(p));
            result.add(emails);
        }
        return result;
    }

    public static String find(String s, Map<String, String> p) {
        return p.get(s).equals(s) ? s : find(p.get(s), p);
    }

    public static class Test {
        public static void main(String[] args) throws Exception {
            List<String> list_1 = new ArrayList<String>();
            List<String> list_2 = new ArrayList<String>();
            List<String> list_3 = new ArrayList<String>();
            List<String> list_4 = new ArrayList<String>();
            List<String> list_5 = new ArrayList<String>();
            list_1.add("John");
            list_1.add("johnsmith@mail.com");
            list_1.add("john00@mail.com");
            list_2.add("John");
            list_2.add("johnnybravo@mail.com");
            list_3.add("John");
            list_3.add("johnsmith@mail.com");
            list_3.add("john_newyork@mail.com");
            list_4.add("Mary");
            list_4.add("mary@mail.com");
            list_5.add("Johns");
            list_5.add("john00@mail.com");
            list_5.add("1298174226@qq.com");
            List<List<String>> lists = new ArrayList<List<String>>();
            lists.add(list_1);
            lists.add(list_2);
            lists.add(list_3);
            lists.add(list_4);
            lists.add(list_5);
            for(List<String> list :  accountsMerge(lists)) {
                for(String s : list) {
                    System.out.print(s + "  ");
                }
                System.out.println();
            }
         }

    }
}
