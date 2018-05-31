package com.zhao.lex.leetcode.microsoft;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by qtfs on 2018/4/20.
 */
public class Package {
    public static void floyd(int numCities, int numRoads, int[][] travelTime, int numDeliveries, int[][] timeLimit) {
        int[][] distance = new int[numCities + 1][numCities + 1];
        int[][] path = new int[numCities + 1][numCities + 1];
        for(int i = 0; i < distance.length; i++)
            Arrays.fill(distance[i], 999999);
        for(int i = 0; i < numRoads; i++) {
            distance[travelTime[i][0]][travelTime[i][1]] = travelTime[i][2];
            path[travelTime[i][0]][travelTime[i][1]] = travelTime[i][1];
        }
        for(int k = 1; k <= numCities; k++) {
            for(int i = 1; i <= numCities; i++) {
                for(int j = 1; j <= numCities; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = k;
                    }

                }
            }
        }
        for(int i = 0; i < numDeliveries; i++) {
            int result = timeLimit[i][1] - 2 * distance[1][timeLimit[i][0]];
            System.out.println(result > 0 ? result : 0);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCities = scanner.nextInt();
        int numRoads = scanner.nextInt();
        int[][] travelTime = new int[numCities][3];
        for(int i = 0; i < numRoads; i++) {
            travelTime[i][0] = scanner.nextInt();
            travelTime[i][1] = scanner.nextInt();
            travelTime[i][2] = scanner.nextInt();
        }
        int numDeliveries = scanner.nextInt();
        int[][] timeLimit = new int[numDeliveries][2];
        for(int i = 0; i < numDeliveries; i++) {
            timeLimit[i][0] = scanner.nextInt();
            timeLimit[i][1] = scanner.nextInt();
        }
        floyd(numCities, numRoads, travelTime, numDeliveries, timeLimit);
    }
}
