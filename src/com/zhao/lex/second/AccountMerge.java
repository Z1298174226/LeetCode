package com.zhao.lex.second;


import java.util.*;

/**
 * Created by qtfs on 2018/9/5.
 */
public class AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> acts) {
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
            String p = find(parents, act.get(1));
            for(int i = 2; i < act.size(); i++) {
                parents.put(find(parents, act.get(i)), p);
            }
        }

        for(List<String> act : acts) {
            for(int i = 1; i < act.size(); i++) {
                String p = find(parents, act.get(i));
                if(!union.containsKey(p)) {
                    union.put(p, new TreeSet<String>());
                }
                union.get(p).add(act.get(i));
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(String p : union.keySet()) {
            List<String> list = new ArrayList<String>(union.get(p));
            list.add(0, owner.get(p));
            result.add(list);
        }
        return result;
    }
    public String find(Map<String, String> parents, String s) {
        return s == parents.get(s) ? s : find(parents, parents.get(s));
    }

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
        for(List<String> list :  new AccountMerge().accountsMerge(lists)) {
            for(String s : list) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }
}
