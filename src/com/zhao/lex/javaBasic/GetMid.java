package com.zhao.lex.javaBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2019/4/6.
 */
public class GetMid {
    List<Integer> list = new ArrayList<Integer>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        if((list.size() & 1) == 1)
            return (double) getMid(list, 0, list.size() - 1, list.size() / 2);
        else {
            int result1 = getMid(list, 0, list.size() - 1, (list.size() - 1) / 2);
            int result2 = getMid(list, 0, list.size() - 1, list.size() / 2);
            return (result1 + result2) / 2.;
        }
    }

    public int getMid(List<Integer> list, int start, int end, int k) {
        if(start >= end) return 0;
      //  int j = partitionUpdate(list, start, end);
        int j = partition(list, start, end);
        if(j < k)
            return getMid(list, j + 1, end, k);
        else if(j > k)
            return getMid(list, start, j - 1, k);
        else
            return list.get(j);
    }

    public int partition(List<Integer> list, int start, int end) {
        int i = start - 1;
        for(int j = 0; j < list.size() - 1; j++) {
            if(less(list, j, end))
                swap(list, ++i, j);
        }
        swap(list, ++i, end);
        return i;
    }

    public int partitionUpdate(List<Integer> list, int start, int end) {
        int i = start; int j = end + 1;
        while(true) {
            while(less(list, ++i, start)) {
                if(i == end) break;
            }
            while(less(list, start, --j)) {
                if(j == start) break;
            }
            if(i >= j) break;
            swap(list, i, j);
        }
        swap(list, j, start);
        return j;
    }

    public boolean less(List<Integer> list, int index1, int index2) {
        return list.get(index1) < list.get(index2);
    }

    public void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.add(index1, list.get(index2));
        list.remove(index1);
        list.add(index2, temp);
        list.remove(index2);
    }

    public static void main(String[] args) {
        GetMid getMid = new GetMid();
        getMid.Insert(4);
        getMid.Insert(5);
        getMid.Insert(6);
        getMid.Insert(7);
        getMid.Insert(8);
        getMid.Insert(8);
        getMid.Insert(8);
        getMid.Insert(8);
        System.out.println(getMid.GetMedian());
    }
}
