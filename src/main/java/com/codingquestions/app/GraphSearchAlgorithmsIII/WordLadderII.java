package com.codingquestions.app.GraphSearchAlgorithmsIII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a begin word, an end word and a dictionary, find the least number
 * transformations from begin word to end word, and return the transformation
 * sequences. Return empty list if there is no such transformations.
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
 * Example: start = "git", end = "hot", dictionary =
 * {"git","hit","hog","hot","got"}
 * 
 * Output: [["git","hit","hot"], ["git","got","hot"]]
 */

public class WordLadderII {
    class Tuple {
        String stringValue;
        int steps;

        public Tuple(String stringValue, int steps) {
            this.stringValue = stringValue;
            this.steps = steps;
        }
    }

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> wordList2 = new ArrayList<>();
        for (String each : wordList) {
            wordList2.add(each);
        }

        HashMap<String, List<String>> neighborsMap = getNeighborsMap(wordList2, beginWord);

        Queue<Tuple> queue = new ArrayDeque<>();// next word to expand
        HashMap<String, HashSet<Tuple>> expanded = new HashMap<>();
        queue.offer(new Tuple(beginWord, 1));
        expanded.put(beginWord, new HashSet<Tuple>());

        while (!queue.isEmpty()) {
            Tuple wordTuple = queue.poll();
            String value = wordTuple.stringValue;
            int steps = wordTuple.steps;

            List<String> neighbors = neighborsMap.get(value);
            for (String eachNeighbor : neighbors) {

                if (expanded.containsKey(eachNeighbor)) {
                    HashSet<Tuple> newVal = expanded.get(eachNeighbor);
                    newVal.add(new Tuple(value, steps));
                    expanded.put(eachNeighbor, newVal);
                } else {
                    HashSet<Tuple> newVal = new HashSet<>();
                    newVal.add(new Tuple(value, steps));
                    expanded.put(eachNeighbor, newVal);
                    queue.offer(new Tuple(eachNeighbor, steps + 1));
                }
            }
        }

        return DFSGetPath(expanded, endWord);
    }

    // FIXME:
    private List<List<String>> DFSGetPath(HashMap<String, HashSet<Tuple>> expanded, String endWord) {
        List<List<String>> result = new ArrayList<>();

        return result;
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
        WordLadderII instance = new WordLadderII();
        // System.out.println(
        // instance.ladderLength("hit", "cog", java.util.Arrays.asList("het", "det",
        // "deg", "let", "leg", "ceg")));
        System.out.println(instance.ladderLength("git", "hot", Arrays.asList("git", "hit", "hog", "hot")));
    }

}