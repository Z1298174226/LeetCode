package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/6/6.
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class CanIWin {
    private Map<Integer, Boolean> dp = new HashMap<>();

    private int newTarget(int n, int state, int desiredTotal) {
        int res = desiredTotal;
        for (int i = 0; i < n; ++i) {
            if (((state >> i) & 0x1) == 0) {
                res -= (i + 1);
            }
        }
        return res;
    }

    private boolean win(int n, int state, int desiredTotal) {
        int target = newTarget(n, state, desiredTotal);
        if (target <= 0 || state == 0) {
            return false;
        }

        if (dp.containsKey(state)) {
            return dp.get(state);
        }
        dp.put(state, false);

        boolean res = false;
        for (int i = 0; i < n; ++i) {
            if (((state >> i) & 0x1) == 1) {
                if (i + 1 >= target) {
                    res = true;
                    break;
                }

                if ((state & ~(1 << i)) == 0) {
                    break;
                }

                boolean tmp = true;
                for (int j = 0; j < n; ++j) {
                    if (j != i && ((state >> j) & 0x1) == 1) {
                        int next = (state & ~(1 << i)) & ~(1 << j);
                        int newTarget = target - (i + 1) - (j + 1);

                        if (!win(n, next, desiredTotal)) {
                            tmp = false;
                            break;
                        }
                    }
                }

                if (tmp) {
                    res = true;
                    break;
                }
            }
        }

        dp.put(state, res);
        return res;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        return win(maxChoosableInteger, (1 << maxChoosableInteger) - 1, desiredTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxChoosaleInteger = scanner.nextInt();
        int desiredTtal = scanner.nextInt();
        CanIWin can = new CanIWin();
        System.out.println(can.canIWin(maxChoosaleInteger, desiredTtal));
    }
}
