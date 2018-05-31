package com.zhao.lex.leetcode;

import java.util.Scanner;
import java.util.Random;
/**
 * Created by qtfs on 2018/4/24.
 */
public class Guess {
    public static void main(String[] args) {
        final String[] words = new String[]{"write", "that", "program", "book", "optimization", "university", "communication"};
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int lengthWords = words.length;
        boolean next = true;
        boolean flag = false;
        boolean match = false;
        boolean have = false;
        while(next) {
            flag = false;
            StringBuilder builder = new StringBuilder();
            int index = rand.nextInt(lengthWords);
            String word = words[index];
            for(int i = 0; i < word.length(); i++)
                builder.append("*");
            while (!flag) {
                have = false;
                match = false;
                System.out.println("Enter a letter in the words : " + builder.toString());
                String s = scanner.next();
                char[] array = s.toCharArray();
                char[] arrayWord = word.toCharArray();
                char[] arrayBuilder = builder.toString().toCharArray();
                for (int i = 0; i < arrayWord.length; i++) {
                    if(arrayBuilder[i] == array[0]) {
                        have = true;
                        break;
                    }
                }
                if(have) {
                    System.out.println(s + " is already in the word");
                    continue;
                }
                for (int i = 0; i < arrayWord.length; i++) {
                    if(arrayWord[i] == array[0]) {
                        builder.replace(i, i + 1, s);
                        match = true;
                    }
                }
                if(!match) System.out.println(s + " is not int the word");
                if(builder.toString().equals(word)) flag = true;
            }
            System.out.println("You are right!");
            System.out.println("Do you want to guess for another word ?");
            if(scanner.next().equals("y")) next = true;
            else next = false;
        }
    }
}
