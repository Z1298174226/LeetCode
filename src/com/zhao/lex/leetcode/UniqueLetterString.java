package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qtfs on 2018/11/15.
 */
public class UniqueLetterString {
    public int uniqueLetterString(String S) {
        if(S == null || S == "") return 0;
        int length = S.length();
        int left = 0; int right = 0;
        int result = 0;
        while(left < length) {
            right = left+ 1;
            while(right <= length) {
                String s = S.substring(left, right);
                result += uniq(s);
                right++;
            }
            left++;
        }
        result += length;
        return result;
    }

    public int uniqueLetterStringUpdate(String S) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i)
            Arrays.fill(index[i], -1);
        int res = 0;
        int N = S.length();
        int mod = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[] {index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }

    private int uniq(String s) {
        HashMap map = new HashMap();
        int[] cnt = new int[26];
        int count = 0;
        for(int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 65]++;
        for(int i = 0; i < s.length(); i++) {
            if(cnt[s.charAt(i) - 65] == 1)
                count++;
        }
        return count;
    }

    final static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
//        String s = "LRAJEMOOWZAQFJCZGTBCPIDUNMASGFXDHIFWEGEAJVJNBMUDHBXXAHUPDRJYKANISYNCQZQFATRBYFLEOHGVPUDJVVRNDADNTGCZFNIIQDVO" +
//                "KMQOCRSHLMUOIRCCLLMYZPVGCYUIVKLUBNZDFHENJFSUCMILYKVBDZVHVYFZIFMOXCIDVXIIDUNFCWPUZSGFVZRVIMHMZWRRNEANZJTMTPTTOWW" +
//                "DZGBQKXLOFPDMUVDFLOJLKITFXJIOEHHDMRLOUOTXSDUWBLMHVWHKYATGKLUEYJJUEDCQLHHKYIGTDUQMKQVUXVOGNXPMWZOBDPMBOSDOGUZPYDP" +
//                "MEUQPEGKWGMEZMJPSSBLXURLKOTCDSVZFCPTTKGOONESMZULOTPTBBJMMFTXQKCHBBBADDOYFKQWYKRIARTDHCSXZEOPEYCDWWZUEABSOJPPYHXR" +
//                "ZNXKZPPYSHUKVXISZMRLZDCNCROWAIWJEHOVHYICTRHOLICFHDPSMJGMDJUMHXUJNAOBZMFACXHPNPFVBXZHNNUZLPEXFPQKCUUSYEQABKLKMXHP" +
//                "WYBSMYPTTZCDZCMMKAORUXKQLEOMLLNHHLGQGGTOYMGNTZZXAXTDEFPXDHGJQYBKVCQZJEGRVDVIAGJOFVNXXONAKNSSDWCILWJKCWLTBVGWIAWV" +
//                "AEHHHOXMMIYXNTKZTJBHOVNPUYNRKDQNJCHPURWUYWCHJCLVQQHBVVTQENYZUDYPFEYZWDNFOZVOZGZISYJQHZDBRILWYYLYIBFJVWFCSVFMNGED" +
//                "HCUFEPRZRWVBHSEZFTISUDGTECQSZIPQILQNCELRMRJLWTOPAWEIDHJUZDVIEHTIVMYZCOSNORIMPLJDYHDRECONKLJDXYRZJRFPKEBLLTHVJYJK" +
//                "BYKOCZLOFUIOVLIFDBUQVVWUXYFUENGATWYNDVKTMKXZQBQCVWDQUXNJDHWEXZKJJXQVEFASXAUFGTGECMLLKDWHQPYGUIQKANLXNWZWOJBLX";
//        System.out.println(new UniqueLetterString().uniqueLetterStringUpdate(s));
        System.out.println(hash("value") & 7);
}

}
