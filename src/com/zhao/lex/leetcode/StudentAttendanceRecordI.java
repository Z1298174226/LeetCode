package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/1/9.
 */
public class StudentAttendanceRecordI {
    public static boolean checkRecord(String s) {
        char[] ch = s.toCharArray();
        int countA = 1;
        int countL = 2;
        for(int i = 0; i < ch.length; i++) {
           if(ch[i] == 'A')
               countA--;
           if(ch[i] == 'L' && i > 0 && i < ch.length - 1 && ch[i - 1] == 'L' && ch[i + 1] == 'L') {
               countL -= 3;
           }

        }
        return countA > -1 && countL > -1;
    }

    public static void main(String[] args) {
        String s  = "ALLPLLPLL";
        System.out.println(checkRecord(s));
    }
}
