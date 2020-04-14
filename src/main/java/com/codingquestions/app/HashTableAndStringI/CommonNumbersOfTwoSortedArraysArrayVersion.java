package com.codingquestions.app.HashTableAndStringI;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Find all numbers that appear in both of two sorted arrays (the two arrays are
 * all sorted in ascending order).
 * 
 * Assumptions
 * 
 * In each of the two sorted arrays, there could be duplicate numbers. Both two
 * arrays are not null. Examples
 * 
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */

// TIEM
// SPACE:
public class CommonNumbersOfTwoSortedArraysArrayVersion {
    // method 1: two pointers
    // TIME: O(m + n)
    // SPACE: O(1)
    public List<Integer> common1(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i <= A.length - 1 && j <= B.length - 1) {
            if (A[i] == B[j]) {
                result.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    // method 2: use HashMap
    // assume size A is m and sizes B is n
    // TIME: O(m + n) in average, O(m2 + M * n) = O(m * n) in worst case
    // SPACE: O(m)
    public List<Integer> common2(int[] A, int[] B) {
        // using array A to build the hashmap
        // key: integer value
        // value: the number of occurance
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : A) {
            // case 1: the element is not in the HashMap
            Integer value = map.get(ele);
            if (value == null) {
                map.put(ele, 1);
            } else { // case 2: the element is in the HashMap
                map.put(ele, value + 1);
            }

        }

        // for each element in B
        // case 1: if ele is in hashmap, we add the ele to the result
        // and decrease the counter’s count. When it reaches 0, remove
        // the ele from the hashmap

        // case 2: if ele is not in hashmap, do nothing
        for (int ele : B) {
            Integer value = map.get(ele);
            if (value != null) {
                result.add(ele);
                if (value - 1 == 0) {
                    map.remove(ele);
                } else {
                    map.put(ele, value - 1);
                }
            }
        }
        return result;
    }

}