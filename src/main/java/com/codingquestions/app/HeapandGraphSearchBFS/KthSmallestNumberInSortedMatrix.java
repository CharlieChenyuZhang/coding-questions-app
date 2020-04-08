package com.codingquestions.app.HeapandGraphSearchBFS;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Given a matrix of size N x M. For each row the elements are sorted in
 * ascending order, and for each column the elements are also sorted in
 * ascending order. Find the Kth smallest number in it.
 * 
 * Assumptions
 * 
 * the matrix is not null, N > 0 and M > 0 K > 0 and K <= N * M Examples
 * 
 * { {1, 3, 5, 7},
 * 
 * {2, 4, 8, 9},
 * 
 * {3, 5, 11, 15},
 * 
 * {6, 8, 13, 18} }
 * 
 * the 5th smallest number is 4 the 8th smallest number is 6
 */

public class KthSmallestNumberInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        // initial state - matrix[0][0]
        // generation/expantion rule

        // generate matrix[i][j]
        // expand matrix[i + 1][j] if i + 1 < #rows
        // && node has not been expanded
        // similar the node matrix[i][j+1]

        // termination condition
        // when we poped out the k-1 elements from the minHeap
        // dedup - HashSet to tract which nodes have been expanded

        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }

                return c1.value < c2.value ? -1 : 1;
            }
        });

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] expandedCells = new int[rows][columns];

        // add the initial state to the minHeap
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        // NOTE: whenever we add to the minHeap, we need to update the expandedCells
        // immediately
        // instead of updating the expandedCells when we poll out the element to avoid
        // adding the same
        // elements to the priorityQueue multiple times
        expandedCells[0][0] = 1;

        // do this k - 1 times
        for (int i = 0; i < k - 1; i++) {
            // pop the element from minHeap to expand
            // add the element to the hashset
            // if row+1 is not out of bound
            // && that cell hasn’e been expanded
            // add to the minHeap
            Cell ele = minHeap.poll();
            int row = ele.row;
            int column = ele.column;

            if (row + 1 < rows && expandedCells[row + 1][column] != 1) {
                minHeap.offer(new Cell(row + 1, column, matrix[row + 1][column]));
                expandedCells[row + 1][column] = 1;
            }

            // similar to column+1
            if (column + 1 < columns && expandedCells[row][column + 1] != 1) {
                minHeap.offer(new Cell(row, column + 1, matrix[row][column + 1]));
                expandedCells[row][column + 1] = 1;
            }
        }
        return minHeap.peek().value;

    }

    public class Cell {
        public int row;
        public int column;
        public int value;

        public Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

}
