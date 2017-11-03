package leetcode;

/**
 * Created by qtfs on 2017/11/3.
 */
public class WildcardMatchingII {
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        int result = 0;
        result = help(s, p, dp, s.length(), p.length());
        if(result == s.length()) return true;
        else return false;
    }

    private static int help(String s, String p, int[][] dp, int len1, int len2) {
        if(dp[len1][len2] != 0) return dp[len1][len2];
        if(len1 == 0 && len2 == 0) return 0;
        else if(len1 == 0) {
            if(len2 == 1) return -1;
            for(int i = 0; i < len2 - 1; i ++) {
                if(p.charAt(i) != '*')
                    if(i + 1 < len2 && p.charAt(i + 1) != '*') return -1;
                    else continue;
                else continue;
            }
            if(p.charAt(len2 - 1) != '*') return -1;
            return 0;
        }
        else if(len2 == 0) return -1;
        if(s.charAt(len1 - 1) == p.charAt(len2 - 1) || p.charAt(len2 - 1) == '.') {
            int temp = help(s, p, dp, len1 - 1, len2 - 1);
            if(temp != -1)  dp[len1][len2] = temp + 1;
            else return -1;
        }else if(p.charAt(len2 - 1) == '*' && ( p.charAt(len2 - 2) == s.charAt(len1 - 1) || p.charAt(len2 - 2) == '.')) {
            int temp_1 = help(s, p, dp, len1 - 1, len2 - 1);
            if(temp_1 != -1) dp[len1][len2] = temp_1 + 1;
            else {
                int temp_2 = help(s, p, dp, len1 - 1, len2);
                if(temp_2 != -1) dp[len1][len2] = temp_2 + 1;
                else {
                    int temp_3 = help(s, p, dp, len1, len2 - 2);
                    dp[len1][len2] = temp_3;
                }
            }
        }else if(p.charAt(len2 - 1) == '*' && p.charAt(len2 - 2) != s.charAt(len1 - 1)) {
            int temp = help(s, p, dp, len1, len2 - 2);
            dp[len1][len2] = temp;
        }
        else {
            return -1;
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
         //String s = "abefcdgiescdfi";   //"abefcdgiescdfimde"
         //String p = "ab*cd.i";
        String s = "aaaa";
        String p = "ab*a*c*aa";
        System.out.println(WildcardMatchingII.isMatch(s, p));
    }
}
