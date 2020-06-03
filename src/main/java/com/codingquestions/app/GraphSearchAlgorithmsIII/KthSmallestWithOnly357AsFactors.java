package com.codingquestions.app.GraphSearchAlgorithmsIII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and
 * y > 0 and z > 0, x, y, z are all integers.
 * 
 * Assumptions
 * 
 * K >= 1 Examples
 * 
 * the smallest is 3 * 5 * 7 = 105 the 2nd smallest is 3 ^ 2 * 5 * 7 = 315 the
 * 3rd smallest is 3 * 5 ^ 2 * 7 = 525 the 5th smallest is 3 ^ 3 * 5 * 7 = 945
 */

public class KthSmallestWithOnly357AsFactors {
    public long kth(int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        Set<Long> visited = new HashSet<>();

        // init state <x,y,z> is <1,1,1>
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while (k > 1) {
            long current = minHeap.poll();
            // x + 1
            if (visited.add(3 * current)) {
                minHeap.offer(3 * current);
            }
            // y + 1
            if (visited.add(5 * current)) {
                minHeap.offer(5 * current);
            }
            // z + 1
            if (visited.add(7 * current)) {
                minHeap.offer(7 * current);
            }
            k--;
        }
        return minHeap.peek();
    }

    // Method 2: linear solution using 3 deques (not required for interviews)
    public long kth2(int k) {
        long seed = 3 * 5 * 7L;

        // semantics
        // deque3 only maintas the value of seed * 3^x
        // deque5 only maintas the value of seed * 5^x
        // deque7 only maintas the value of seed * 7^x
        Deque<Long> three = new ArrayDeque<>();
        Deque<Long> five = new ArrayDeque<>();
        Deque<Long> seven = new ArrayDeque<>();

        three.add(seed * 3);
        five.add(seed * 5);
        seven.add(seed * 7);

        long result = seed;
        while (k > 1) {
            if (three.peekFirst() < five.peekFirst() && five.peekFirst() < seven.peekFirst()) {
                result = three.pollFirst();
                three.offerLast(result * 3);
                five.offerLast(result * 5);
                seven.offerLast(result * 7);
            } else if (five.peekFirst() < three.peekFirst() && five.peekFirst() < seven.peekFirst()) {
                result = five.pollFirst();
                five.offerLast(result * 5);
                seven.offerLast(result * 7);
            } else {
                result = seven.pollFirst();
                seven.offerLast(result * 7);
            }
        }
        return result;
    }

}