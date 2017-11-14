package leetcode;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2017/11/13.
 */
public class OfoCombination {
    public static List<List<Integer>> getCombination(int n, int k) {
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        return dfs(map, n, k, 1);
    }
    private static List<List<Integer>> dfs(Map<Integer, List<List<Integer>>> map, int n, int k, int index) {
        if(map.containsKey(k)) return map.get(k);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i = index; i <= n; i++) {
            if(k == 1) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                lists.add(list);
            }else {
                List<List<Integer>> subLists = dfs(map, n, k - 1, i);
                for(List<Integer> subList : subLists) {
                    List<Integer> newList = new ArrayList(subList);
                    if(!lists.contains(newList)) {
                        newList.add(i);
                        lists.add(newList);
                    }
                }
            }
        }
        map.put(k, lists);
        return lists;
    }
    public static void main(String[] args) {
        int number = 0;
        for(List<Integer> list : OfoCombination.getCombination(5, 5)) {
            for(int num : list) {
                System.out.print(String.format("%4d", num));
            }
            System.out.println();
            number++;
        }
        System.out.println("The whole number is : " + number);
    }
}
