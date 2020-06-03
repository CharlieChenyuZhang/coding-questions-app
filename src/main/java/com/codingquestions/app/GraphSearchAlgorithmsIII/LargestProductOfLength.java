package com.codingquestions.app.GraphSearchAlgorithmsIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given a dictionary containing many words, find the largest product of two
 * words’ lengths, such that the two words do not share any common characters.
 * 
 * Assumptions
 * 
 * The words only contains characters of 'a' to 'z' The dictionary is not null
 * and does not contains null string, and has at least two strings If there is
 * no such pair of words, just return 0 Examples
 * 
 * dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 =
 * 10 (by choosing “abcde” and “xy”)
 */

public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String s0, String s1) {
                if (s0.length() == s1.length()) {
                    return 0;
                }
                return s0.length() > s1.length() ? -1 : 1;
            }
        });

        int largest = 0;

        // i is the index of the second word
        for (int i = 1; i < dict.length; i++) {
            // j is the index of the first word
            for (int j = 0; j < i; j++) {
                int prod = dict[i].length() * dict[j].length();
                // there is no need to continue if product is
                // already smaller than the largest
                if (prod <= largest) {
                    break;
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                if ((iMask & jMask) == 0) {
                    largest = prod;
                }
            }
        }
        return largest;
    }

    private HashMap<String, Integer> getBitMasks(String[] dict) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++) {
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }

    // method 2 (better, BFSII)
    class Cell {
        int row;
        int col;
        int value;

        public Cell(int row, int column, int value) {
            this.row = row;
            this.col = column;
            this.value = value;
        }
    }

    public int largestProduct2(String[] dict) {
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String s0, String s1) {
                if (s0.length() == s1.length()) {
                    return 0;
                }
                return s0.length() > s1.length() ? -1 : 1;
            }
        });

        int largest = 0;
        boolean[][] expanded = new boolean[dict.length][dict.length];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value > c2.value ? -1 : 1;
            }
        });

        // minHeap store the Cell to be expanded next
        minHeap.offer(new Cell(0, 1, dict[0].length() * dict[1].length()));
        expanded[0][1] = true;

        while (minHeap.size() != 0) {
            Cell cur = minHeap.poll();
            int rowIndex = cur.row;
            int colIndex = cur.col;

            if ((bitMasks.get(dict[rowIndex]) & bitMasks.get(dict[colIndex])) == 0) {
                largest = Math.max(largest, cur.value);
            }

            // generate
            if (rowIndex + 1 < colIndex && rowIndex + 1 < dict.length - 1
                    && expanded[rowIndex + 1][colIndex] == false) {
                expanded[rowIndex + 1][colIndex] = true;
                minHeap.offer(new Cell(rowIndex + 1, colIndex, dict[rowIndex + 1].length() * dict[colIndex].length()));
            }

            if (colIndex + 1 < dict.length && expanded[rowIndex][colIndex + 1] == false) {
                expanded[rowIndex][colIndex + 1] = true;
                minHeap.offer(new Cell(rowIndex, colIndex + 1, dict[rowIndex].length() * dict[colIndex + 1].length()));
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        LargestProductOfLength instance = new LargestProductOfLength();
        System.out.println(instance.largestProduct2(new String[] { "aa", "bb", "ccc", "abcfgh", "ehi" }));
    }

}