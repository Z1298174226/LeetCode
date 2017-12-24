package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by qtfs on 2017/12/24.
 */
public class SentenceSimilarityII {
    public static boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> paris) {
        Map<String, String> parents = new HashMap<String, String>();
        for(String word : words1)
            parents.put(word, word);
        for(String word : words2)
            parents.put(word, word);
        for(List<String> pair : paris) {
            parents.put(pair.get(0), pair.get(0));
            parents.put(pair.get(1), pair.get(1));
        }
        for(List<String> list : paris) {
            String p = parents.get(list.get(0));
            parents.put(find(parents.get(list.get(1)), parents), p);
        }
        for(int i = 0; i < words1.size(); i++) {
            if(parents.get(words1.get(i)) != parents.get(words2.get(i)))
                return false;
        }
        return true;
    }

    private static String find(String word, Map<String, String> parents) {
        return parents.get(word) == word ? word : find(parents.get(word), parents);
    }

    public static class Test{
        public static void main(String[] args) {
            List<String> words1 = new ArrayList<String>();
            List<String> words2 = new ArrayList<String>();
            words1.add("great");
            words1.add("acting");
            words1.add("skills");
            words2.add("fine");
            words2.add("drama");
            words2.add("talent");
            List<List<String>> pairs = new ArrayList<List<String>>();
            List<String> pair1 = new ArrayList<String>();
            List<String> pair2 = new ArrayList<String>();
            List<String> pair3 = new ArrayList<String>();
            List<String> pair4 = new ArrayList<String>();
            pair1.add("great");
            pair1.add("good");
            pair2.add("good");
            pair2.add("fine");
            pair3.add("acting");
            pair3.add("drama");
            pair4.add("skills");
            pair4.add("talent");
            pairs.add(pair1);
            pairs.add(pair2);
            pairs.add(pair3);
            pairs.add(pair4);
            System.out.println(areSentencesSimilarTwo(words1, words2, pairs));
        }

    }
}
