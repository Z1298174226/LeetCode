package com.zhao.lex.leetcode.meituan;

import java.util.*;
import org.junit.Test;
/**
 * Created by qtfs on 2018/3/27.
 */
public class AccountMerge {

    @Test
    public static void accountMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, String> parents = new HashMap<String, String>();
        Map<String, String> owner = new HashMap<String, String>();
        Map<String, TreeSet<String>> union = new HashMap<String, TreeSet<String>>();

        for(List<String> account : accounts) {
            for(int i = 1; i < account.size(); i++) {
                 parents.put(account.get(i), account.get(i));
                 owner.put(account.get(i), account.get(0));
            }
        }

        for(List<String> account : accounts) {
            String p = find(account.get(1), parents);
            for(int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i), parents), p);
            }
        }

        for(List<String> account : accounts) {
            for(int i = 1; i < account.size(); i++) {
                String p = find(account.get(i), parents);
                if(union.containsKey(p)) {
                    union.put(p, new TreeSet<String>());
                    union.get(p).add(account.get(i));
                }
            }
        }

        for(String s : union.keySet()) {
            List<String> list = new ArrayList<String>();
            list.add(owner.get(s));
            list.addAll(union.get(s));
            result.add(list);
        }
    }

    public static String find(String p, Map<String, String> parents) {
        return p == parents.get(p) ? p : find(parents.get(p), parents);
    }


}
