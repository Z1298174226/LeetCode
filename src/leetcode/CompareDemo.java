package leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/17.
 */
public class CompareDemo<K extends Comparable<K>> {
    Comparator<K> com = new Comparator<K>() {
        @Override
        public int compare(K o1, K o2) {
            return o1.compareTo(o2);
        }
    };
    public void func(K k1) {

    }

    public static <K extends Comparable<K>> void main(String[] args) {
        List<K> list = new ArrayList<K>();
        CompareDemo<Integer> c = new CompareDemo<>();
        System.out.println(c.getClass().getConstructors());
        Collections.sort(list);
    }
}
