package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/11/9.
 */
public class SplitArrayintoFibonacciSequence
{
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<Integer>();
        int length = S.length();
        boolean flag = false;
        for(int first = 1; first < length; first++) {
            if(first > 14)
                break;
            for(int second = first + 1; second < length; second++) {
                if(S.substring(0, first).startsWith("0") && S.substring(0, first).length() > 1) break;
                long num1 = Long.valueOf(S.substring(0, first));
                if(second - first > 14) continue;
                if(S.substring(first, second).startsWith("0") && S.substring(first, second).length() > 1) break;
                long num2 = Long.valueOf(S.substring(first, second));
                list.add((int)num1);
                list.add((int)num2);
                flag = dfs(list, second, (int)num1, (int)num2,  S);
                if(flag)
                    return list;
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
        return list;
    }

    public boolean dfs(List<Integer> list, int last, int num1, int num2, String S) {
        if(last + 1 == S.length() + 1) {
            return true;
        }
       boolean flag = false;
       for(int i = last + 1; i <= S.length(); i++) {
            if(i - last > 14) break;
            if(S.substring(last, i).startsWith("0") && S.substring(last, i).length() > 1) return flag;
            long num3 = Long.valueOf(S.substring(last, i));
            if(num1 + num2 == num3) {
                list.add((int)num3);
                flag = flag || dfs(list, i, num2, (int)num3, S);
                if(flag)
                    return flag;
                list.remove(list.size() - 1);
            }
        }
        return flag;
    }

    public List<Integer> splitIntoFibonaccii(String S) {
        List<Integer> result = new ArrayList();
        split(S, 0, result);
        return result;
    }

    private Boolean split(String S, int index, List<Integer> list) {
        if (index == S.length() && list.size() > 2) {
            return true;
        }
        long temp = 0;
        for (int i = index; i < S.length(); i++) {
            if (S.charAt(index) == '0' && i > index) { //if start with 0, then it can only be 0
                break;
            }
            temp = temp * 10 + (S.charAt(i) - '0');
            if (temp > Integer.MAX_VALUE)
                return false;
            if (list.size() > 1 && (int)temp > list.get(list.size()-1) + list.get(list.size()-2)) {
                break; //early termination if already larger than the previous two sum
            }
            if (list.size() <= 1 || (int)temp == list.get(list.size()-1) + list.get(list.size()-2)) {
                list.add((int)temp);
                if (split(S,i+1,list))
                    return true;
                list.remove(list.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayintoFibonacciSequence().splitIntoFibonacci("417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755"));
    }
}
