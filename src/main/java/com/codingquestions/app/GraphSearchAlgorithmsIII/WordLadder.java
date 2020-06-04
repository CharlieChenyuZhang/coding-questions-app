package com.codingquestions.app.GraphSearchAlgorithmsIII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a begin word, an end word and a dictionary, find the least number
 * transformations from begin word to end word, and return the length of the
 * transformation sequence. Return 0 if there is no such transformations.
 * 
 * In each transformation, you can only change one letter, and the word should
 * still in the dictionary after each transformation.
 * 
 * Assumptions
 * 
 * 1. All words have the same length.
 * 
 * 2. All words contain only lowercase alphabetic characters.
 * 
 * 3. There is no duplicates in the word list.
 * 
 * 4.The beginWord and endWord are non-empty and are not the same.
 * 
 * Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot"}
 * 
 * Output: 3
 * 
 * Explanation: git -> hit -> hot
 */

public class WordLadder {
    class Tuple {
        String stringValue;
        int steps;

        public Tuple(String stringValue, int steps) {
            this.stringValue = stringValue;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> wordList2 = new ArrayList<>();
        for (String each : wordList) {
            wordList2.add(each);
        }

        HashMap<String, List<String>> neighborsMap = getNeighborsMap(wordList2, beginWord);

        Queue<Tuple> queue = new ArrayDeque<>();// next word to expand
        HashSet<String> expanded = new HashSet<>();
        queue.offer(new Tuple(beginWord, 1));
        expanded.add(beginWord);

        while (!queue.isEmpty()) {
            Tuple wordTuple = queue.poll();
            String value = wordTuple.stringValue;
            int steps = wordTuple.steps;

            if (value.equals(endWord)) {
                return steps;
            }

            List<String> neighbors = neighborsMap.get(value);
            for (String eachNeighbor : neighbors) {
                if (eachNeighbor.equals(endWord)) {
                    return steps + 1;
                }

                if (expanded.add(eachNeighbor)) {
                    queue.offer(new Tuple(eachNeighbor, steps + 1));
                }
            }
        }
        return 0;
    }

    private HashMap<String, List<String>> getNeighborsMap(List<String> wordList, String beginWord) {
        // put everything into a HashSet
        Set<String> stringSet = new HashSet<>();

        for (String each : wordList) {
            stringSet.add(each);
        }

        // add the beginWord to the wordList if they are not in already
        if (stringSet.add(beginWord)) {
            wordList.add(beginWord);
        }

        HashMap<String, List<String>> result = new HashMap<>();
        for (String each : wordList) {
            List<String> neighbors = new ArrayList<>();
            StringBuilder wordModifier = new StringBuilder(each);
            for (int i = 0; i < each.length(); i++) {
                char orig = each.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == orig) {
                        continue;
                    }
                    wordModifier.setCharAt(i, c);
                    String tmp = wordModifier.toString();
                    if (stringSet.contains(tmp)) {
                        neighbors.add(tmp);
                    }
                    wordModifier.setCharAt(i, orig);
                }
            }
            result.put(each, neighbors);
        }
        return result;
    }

    public static void main(String[] argv) {
        WordLadder instance = new WordLadder();
        System.out.println(
                instance.ladderLength("hit", "cog", java.util.Arrays.asList("het", "det", "deg", "let", "leg", "ceg")));
    }

}