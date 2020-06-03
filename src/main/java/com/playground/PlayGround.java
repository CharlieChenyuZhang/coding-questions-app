package com.playground;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.codingquestions.app.util.TreeNode;
import com.codingquestions.app.util.PersonEnum;
import com.codingquestions.app.util.RainbowColorEnum;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Queue;
import java.lang.Comparable;
import java.util.PriorityQueue;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.playground.Person;
import com.playground.Employee;
import com.playground.MyAbstractClass;
import java.lang.ArithmeticException;
import java.io.IOException;
import java.lang.AbstractMethodError;
import java.lang.Exception;
import java.lang.RuntimeException;

public class PlayGround<E extends Object & Comparable<E> & Iterable<E>> {

    static class Board {
        public final static int R = 2;
        public final static int C = 2;
        private int[][] board = new int[R][C];

        public Board() {
        }

        public Board(int[] values) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = values[i * C + j];
                }
            }
        }

        public void swap(int i1, int j1, int i2, int j2) {
            int temp = board[i1][i2];
            board[i1][j1] = board[i2][j2];
            board[i2][j2] = temp;
        }

        public int[] findZero() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 0) {
                        return new int[] { i, j };
                    }
                }
            }
            return null;
        }

        // i is row number, j is column number
        public boolean outOfBound(int i, int j) {
            return i < 0 || i >= R || j < 0 || j >= C;
        }

        @Override
        public int hashCode() {
            int code = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    code = code * 10 + board[i][j];
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Board)) {
                return false;
            }

            Board b = (Board) o;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] != b.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Board clone() {
            Board c = new Board();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    c.board[i][j] = board[i][j];
                }
            }
            return c;
        }
    }

    public static void main(String[] args) throws Exception, IOException {
        HashMap<Board, Integer> map = new HashMap<>();
        Board t1 = new Board(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });
        map.put(t1, 12);
        Board t2 = new Board(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });
        System.out.println(map.get(t2));
    }
}
