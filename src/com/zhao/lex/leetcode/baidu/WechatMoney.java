package com.zhao.lex.leetcode.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by qtfs on 2018/8/2.
 */
public class WechatMoney {
    public static List<Integer> divideRepackage (Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<Integer>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for(int i = 0; i < totalPeopleNum - 1; i++) {
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amontList = divideRepackage(5000, 30);
        for(Integer am : amontList) {
            System.out.println(am);
        }
    }
}
