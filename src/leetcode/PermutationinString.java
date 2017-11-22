package leetcode;

/**
 * Created by qtfs on 2017/11/19.
 */
public class PermutationinString {
    public static boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[256];
        int[] now = new int[256];
        for(int i = 0; i < s1.length(); i++)
            cnt[s1.charAt(i)]++;
        int right = 0; int left = 0;
       while(left < s2.length()) {
            while(right < s2.length() && now[s2.charAt(right)] + 1 <= cnt[s2.charAt(right)]) {
                    now[s2.charAt(right)] += 1;
                    right++;
            }
            if(right - left == s1.length()) return true;
            if(left <= right) now[s2.charAt(left)]--;
            left++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(PermutationinString.checkInclusion(s1, s2));
    }
}
