package com.zhao.lex.intelligent_Algorithm.simulatedannealing;

import java.util.Scanner;
/**
 * Created by qtfs on 2018/5/31.
 */
public class SATest {
    public static final int T = 100;// 初始化温度
    public static final double Tmin = 1e-18;// 温度的下界
    public static final int k = 1000;// 迭代的次数
    public static final double delta = 0.98;// 温度的下降率

    public static double getX() {
        return Math.random() * 100;
    }


    public static double getFuncResult(double x, double y) {
        double result = 6 * Math.pow(x, 7) + 8 * Math.pow(x, 6) + 7
                * Math.pow(x, 3) + 5 * Math.pow(x, 2) - x * y;

        return result;
    }

    /**
     * 模拟退火算法的过程
     * @paramy目标函数中的一个参数
     * @return最优解
     */
    public static double getSA(double y) {
        double result = Double.MAX_VALUE;// 初始化最终的结果
        double t = T;
        double x[] = new double[k];
        // 初始化初始解
        for (int i = 0; i < k; i++) {
            x[i] = getX();
        }
        // 迭代的过程
        while (t > Tmin) {
            for (int i = 0; i < k; i++) {
                // 计算此时的函数结果
                double funTmp = getFuncResult(x[i], y);
                // 在邻域内产生新的解
                double x_new = x[i] + (Math.random() * 2 - 1) * t;
                // 判断新的x不能超出界
                if (x_new >= 0 && x_new <= 100) {
                    double funTmp_new = getFuncResult(x_new, y);
                    if (funTmp_new - funTmp < 0) {
                        // 替换
                        x[i] = x_new;
                    } else {
                        // 以概率替换
                        double p = 1 / (1 + Math
                                .exp(-(funTmp_new - funTmp) / t));
                        if (Math.random() < p) {
                            x[i] = x_new;
                        }
                    }
                }
            }
            t = t * delta;
        }
        for (int i = 0; i < k; i++) {
            result = Math.min(result, getFuncResult(x[i], y));
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int y = scanner.nextInt();
            System.out.println("最优解为：" + getSA(y));
        }
    }

}