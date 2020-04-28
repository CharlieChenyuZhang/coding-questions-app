package com.codingquestions.app.RecursionII;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two
 * Queens threaten each other.
 * 
 * Assumptions
 * 
 * N > 0 Return
 * 
 * A list of ways of putting the N Queens Each way is represented by a list of
 * the Queen's y index for x indices of 0 to (N - 1) Example
 * 
 * N = 4, there are two ways of putting 4 queens:
 * 
 * [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the
 * second row is at y index 3, the Queen on the third row is at y index 0 and
 * the Queen on the fourth row is at y index 2.
 * 
 * [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the
 * second row is at y index 0, the Queen on the third row is at y index 3 and
 * the Queen on the fourth row is at y index 1.
 * 
 * 
 */

// TIME:
// SPACE:

public class NQueens {
    // method 1: O(n) to check if its valid or not
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        helper(n, result, cur);
        return result;
    }

    private void helper(int n, List<List<Integer>> result, List<Integer> cur) {
        // base case
        if (n == cur.size()) {
            result.add(new ArrayList<Integer>(cur));
        }

        // recursive rule
        // i represents the column
        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, result, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < cur.size(); i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }

    // method 2: O(1) to check if its valid or not but using extra storage
    public List<List<Integer>> nqueens2(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] cur = new int[n];
        HashSet<Integer> usedColumns = new HashSet<>();
        HashSet<Integer> usedDiagonals = new HashSet<>();
        HashSet<Integer> usedRevDiagonals = new HashSet<>();

        helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
        return result;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> result, HashSet<Integer> usedColumns,
            HashSet<Integer> usedDiagonals, HashSet<Integer> usedRevDiagonals) {
        // base case, because row starts from 0
        if (row == n) {
            result.add(toList(cur));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
                mark(row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                cur[row] = i;
                helper(n, row + 1, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
                unmark(row, i, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }

    private void mark(int row, int column, HashSet<Integer> usedColumns, HashSet<Integer> usedDiagonals,
            HashSet<Integer> usedRevDiagonals) {
        usedColumns.add(column);
        usedDiagonals.add(column + row);
        usedRevDiagonals.add(column - row);
    }

    private void unmark(int row, int column, HashSet<Integer> usedColumns, HashSet<Integer> usedDiagonals,
            HashSet<Integer> usedRevDiagonals) {
        usedColumns.remove(column);
        usedDiagonals.remove(column + row);
        usedRevDiagonals.remove(column - row);
    }

    private boolean valid(int row, int column, HashSet<Integer> usedColumns, HashSet<Integer> usedDiagonals,
            HashSet<Integer> usedRevDiagonals) {
        return !usedColumns.contains(column) && !usedDiagonals.contains(column + row)
                && !usedRevDiagonals.contains(column - row);
    }

    private List<Integer> toList(int[] cur) {
        List<Integer> list = new ArrayList<>();
        for (int num : cur) {
            list.add(num);
        }
        return list;
    }

}