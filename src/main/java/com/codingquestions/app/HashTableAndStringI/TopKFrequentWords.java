package com.codingquestions.app.HashTableAndStringI;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Comparator;

/**
 * Given a composition with different kinds of words, return a list of the top K
 * most frequent words in the composition.
 * 
 * Assumptions
 * 
 * the composition is not null and is not guaranteed to be sorted K >= 1 and K
 * could be larger than the number of distinct words in the composition, in this
 * case, just return all the distinct words Return
 * 
 * a list of words ordered from most frequent one to least frequent one (the
 * list could be of size K or smaller than K) Examples
 * 
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2
 * frequent words are [“b”, “c”] Composition = ["a", "a", "b", "b", "b", "b",
 * "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5
 * frequent words are [“b”, “c”, "a", "d"]
 */

// TIME: O(n + k + (n-k)logk)
// SPACE: O(n + k)
public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // base case:
        if (combo.length == 0) {
            return new String[0];
        }

        // step 1: build the hashMap
        HashMap<String, Integer> dict = new HashMap<>();
        buildHashMap(combo, dict);
        // step 2: build the minHeap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });

        buildMinHeap(minHeap, dict, k);

        // step 3: build the result
        return buildResult(minHeap);
    }

    private void buildHashMap(String[] combo, HashMap<String, Integer> dict) {
        for (String each : combo) {
            Integer freq = dict.get(each);
            if (freq == null) {
                dict.put(each, 1);
            } else {
                dict.put(each, freq + 1);
            }
        }
    }

    private void buildMinHeap(PriorityQueue<Map.Entry<String, Integer>> minHeap, HashMap<String, Integer> dict, int k) {
        // for the first k element, I can mindlessly add it
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
    }

    private String[] buildResult(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

}