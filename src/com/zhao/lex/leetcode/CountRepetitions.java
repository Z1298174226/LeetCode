package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/10/29.
 */
public class CountRepetitions {
  /*
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count = 0;
        int k = 0;
        int index = 0; int repTime = 0;
        int[] rests = new int[200]; int[] reps = new int[200];
        while(k == count) {
            count++;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if(index == s2.length()) {
                        repTime++;
                        index = 0;
                    }
                }
            }
            if(count > n1) return repTime / n2;
            for(k = 0; k <count; k++) {
                if(index == rests[k])
                    break;
            }
            reps[count] = repTime;
            rests[count] = index;
        }

        int interval = count - k;
        int repeatCount = (n1 - k) / interval;
        int repeatTimes = repeatCount * (reps[count] - reps[k]);
        int remainTimes = reps[(n1 - k) % interval + k];
        return (repeatTimes + remainTimes) / n2;

//        int repeatCount = n1 / count;
//        int repeatTimes = repeatCount * reps[count];
//        int remainTimes = reps[(n1 - k) % interval + k];
//        return repeatTimes / n2;
    }
*/
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count = 0; int index = 0; int k = 0;
        int repTime = 0;
        int[] reps = new int[102]; int[] remains = new int[102];
        while(k == count) {
            count++;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if(index == s2.length()) {
                        index = 0;
                        repTime++;
                    }
                }
            }
//            if(repTime > n1)
//                return repTime / n2;
            for(k = 0; k < count; k++) {
                if(remains[k] == index)
                    break;
            }
            reps[count] = repTime;
            remains[count] = index;
        }
        int interval = count - k;
        int repeat = (n1 - k) / interval * (reps[count] - reps[k]);
        //int remain = reps[(n1 - k) % interval + k];
        int remain = reps[(n1 - k) % interval] + reps[k];
        return (repeat + remain) / n2;
    }
    public static void main(String[] args) {
        System.out.println(CountRepetitions.getMaxRepetitions("nlhqgllunmelayl",100000000, "lnl",1000));
    }
}
