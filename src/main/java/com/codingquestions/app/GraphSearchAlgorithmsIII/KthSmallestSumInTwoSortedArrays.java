package com.codingquestions.app.GraphSearchAlgorithmsIII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given two sorted arrays A and B, of sizes m and n respectively. Define s = a
 * + b, where a is one element from A and b is one element from B. Find the Kth
 * smallest s out of all possible s'.
 * 
 * Assumptions
 * 
 * A is not null and A is not of zero length, so as B K > 0 and K <= m * n
 * Examples
 * 
 * A = {1, 3, 5}, B = {4, 8}
 * 
 * 1st smallest s is 1 + 4 = 5 2nd smallest s is 3 + 4 = 7 3rd, 4th smallest s
 * are 9 (1 + 8, 4 + 5) 5th smallest s is 3 + 8 = 11
 */

public class KthSmallestSumInTwoSortedArrays {
    // BFS2
    // initial state A[0] + B[0] <i, j>
    // expansion and generation rule
    // expand A[i] + B[j]
    // generate A[i+1] + B[j]
    // generate A[i] + B[j + 1]
    // termination condition
    // when we pop the kth times
    // dedup
    // yes, since one state can eb generated more than once

    class Cell {
        int x;
        int y;
        int val;

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 } };

    public int kthSum(int[] A, int[] B, int k) {
        // handle corner cases
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

        if (A.length * B.length < k) {
            return -1;
        }

        // K >= m * n
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
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
                if (neiX >= 0 && neiX < rows && neiY >= 0 && neiY < columns && visited[neiX][neiY] == false) {
                    visited[neiX][neiY] = true;
                    minHeap.offer(new Cell(neiX, neiY, A[neiX] + B[neiY]));
                }
            }
        }
        return minHeap.peek().val;
    }

    public static void main(String[] args) {
        KthSmallestSumInTwoSortedArrays instance = new KthSmallestSumInTwoSortedArrays();
        System.out.println(instance.kthSum(new int[] { 1, 3, 5, 8, 9 }, new int[] { 2, 3, 4, 7 }, 14));
    }

}