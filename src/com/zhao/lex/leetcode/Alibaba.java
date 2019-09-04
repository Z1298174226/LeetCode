package com.zhao.lex.leetcode;

import java.util.Scanner;

/**
 * Created by qtfs on 2019/4/12.
 */
public class Alibaba {
    private static int totalPrice(int categoryCount, int totalVolume, int totalWeight, int[] volume, int[] weight,
                                  int[] stock, int[] price, int[] itemType) {

        int[][] dp = new int[totalVolume + 1][totalWeight + 1];
        int[][] dp1 = new int[totalVolume + 1][totalWeight + 1];

        for (int i = 0; i <= totalVolume; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i <= totalVolume; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                dp1[i][j] = 0;
            }
        }
//

        for (int i = 1; i <= categoryCount; i++) {
            if (i == 1) continue;
            for (int l = 1; l <= stock[i]; l++) {
                for (int j = totalVolume; j >= l * volume[i]; j--) {
                    for (int k = totalWeight; k >= l * weight[i]; k--) {
                        if (j - l * volume[i] >= 0 && k - l * weight[i] >= 0 && dp[j][k] < dp[j - l * volume[i]][k - l * weight[i]] + l * price[i]) {
                            dp[j][k] = dp[j - l * volume[i]][k - l * weight[i]] + l * price[i];
                        }
                    }
                }
            }
        }


        for (int i = 1; i <= categoryCount; i++) {
            if (i == 3) continue;
            for (int l = 1; l <= stock[i]; l++) {
                for (int j = totalVolume; j >= l * volume[i]; j--) {
                    for (int k = totalWeight; k >= l * weight[i]; k--) {
                        if (j - l * volume[i] >= 0 && k - l * weight[i] >= 0 && dp1[j][k] < dp1[j - l * volume[i]][k - l * weight[i]] + l * price[i]) {//
                            dp1[j][k] = dp1[j - l * volume[i]][k - l * weight[i]] + l * price[i];
                        }
                    }
                }
            }
        }

        return Math.max(dp[totalVolume][totalWeight], dp1[totalVolume][totalWeight]);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        //总共商品种类
        int categoryCount = Integer.valueOf(line[0]);
        //快递体积
        int totalVolume = Integer.valueOf(line[1]);
        //快递重量
        int totalWeight = Integer.valueOf(line[2]);

        //物品体积
        int[] volume = new int[50];
        //重量
        int[] weight = new int[50];
        //件数
        int[] stock = new int[50];
        //价格
        int[] price = new int[50];
        //类型
        int[] itemType = new int[50];

        for (int i = 1; i <= categoryCount; i++) {
            line = in.nextLine().split(",");
            volume[i] = Integer.valueOf(line[0]);
            weight[i] = Integer.valueOf(line[1]);
            stock[i] = Integer.valueOf(line[2]);
            price[i] = Integer.valueOf(line[3]);
            itemType[i] = Integer.valueOf(line[4]);
        }

        in.close();

        System.out.println(totalPrice(categoryCount, totalVolume, totalWeight, volume, weight, stock, price, itemType));

    }
    /*
    3,40,30
10,10,10,10,1
13,10,12,11,3
3,4,6,5,3
     */

}
