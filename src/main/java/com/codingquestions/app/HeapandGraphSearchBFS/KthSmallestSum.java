package com.codingquestions.app.HeapandGraphSearchBFS;

import java.util.*;

/**
 * Given two sorted arrays A and B. We can pick one elemnt a from A
 * and another element b from B, and their sum s is defined to be
 * s = a + b. Find the k-th smallest s from all possible values of s.
 */

// BFS2 - best first search
/**
 * initia state: A[0] + B[0]
 * 
 * exp/gen rule:
 * expand A[i] + B[j]
 * generate A[i + 1] + B[j]
 * generate A[i] + B[j + 1]
 * 
 * term condition: when we pop the k-th item
 * dedup: we don't generate the same element twice
 */
public class KthSmallestSum {
    class Cell {
        int x;
        int y;
        int val;

        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 } };

    public int KthSmallest(int[] A, int[] B, int k) {
        // corner cases
        if (A == null || A.length == 0) {
            if (B == null || B.length < k) {
                return -1;
            } else {
                return B[k - 1];
            }
        }
        if (B == null || B.length == 0) {
            if (A == null || A.length < k) {
                return -1;
            } else {
                return A[k - 1];
            }
        }
        if (A.length + B.length < k) {
            return -1;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val) {
                    return 0;
                }
                return c1.val < c2.val ? -1 : 1;
            }
        });
        int rows = A.length;
        int columns = B.length;
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, A[0] + B[0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            for (int[] dir : dirs) {
                int neiX = cur.x + dir[0];
                int neiY = cur.y + dir[1];
                if (neiX >= 0 && neiX < rows && neiY >= 0 && neiY < columns && !visited[neiX][neiY]) {
                    visited[neiX][neiY] = true;
                    minHeap.offer(new Cell(neiX, neiY, A[neiX] + A[neiY]));
                }
            }
        }
        return minHeap.peek().val;
    }
}
