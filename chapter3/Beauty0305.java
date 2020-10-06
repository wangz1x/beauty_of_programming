package com.wzx.beauty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Beauty0305 {
    public static void main(String[] args) {
        String[] article = {"the", "but", "but", "public", "could", "add", "and", "but", "and", "subtract", "but", "to", "divide"};
        String[] words = {"and", "but"};
        System.out.println(Arrays.toString(shortestAbstract(article, words)));
    }

    public static int[] shortestAbstract(String[] article, String[] words) {
        int begin = 0;
        int end = 0;
        int distance = 0x7fffffff;
        int shortBegin = 0;
        int shortEnd = 0;

        Map<String, Integer> wordsTable = new HashMap<>();
        int totalCountWords = 0;
        for (String word : words
        ) {
            totalCountWords++;
            Integer times;
            wordsTable.put(word, (times = wordsTable.get(word)) == null ? 1 : times + 1);
        }
        while (begin < article.length && end < article.length) {
            while (totalCountWords > 0 && end < article.length) {
                if (wordsTable.containsKey(article[end])) {
                    if (wordsTable.get(article[end]) > 0) {
                        totalCountWords--;
                    }
                    // save result of word times in article subtract times in words
                    // if result less equal than 0, means the sequence contains all words
                    wordsTable.put(article[end], wordsTable.get(article[end]) - 1);
                }
                end++;
            }

            while (totalCountWords == 0 && begin < end) {
                if (end - begin < distance) {
                    distance = end - begin;
                    shortBegin = begin;
                    shortEnd = end;
                }
                if (wordsTable.containsKey(article[begin])) {
                    if (wordsTable.get(article[begin]) == 0) {
                        totalCountWords++;
                    }
                    // save result of word times in article subtract times in words
                    // if result less equal than 0, means the sequence contains all words
                    wordsTable.put(article[begin], wordsTable.get(article[begin]) + 1);
                }
                begin++;
            }
        }

        return new int[]{shortBegin, shortEnd - 1};
    }
}
