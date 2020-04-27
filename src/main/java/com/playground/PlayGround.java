package com.playground;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import com.codingquestions.app.utils.TreeNode;
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
import java.lang.AbstractMethodError;
import java.lang.Exception;

public class PlayGround {

    private int powerHelper(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int half = powerHelper(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }

    public double power(int a, int b) {
        if (a == 0) {
            if (b <= 0) {
                return -1 * 1l;
            }
            return 0;
        }

        if (b >= 0) {
            return powerHelper(a, b);
        } else {
            return powerHelper(a, -b);
        }
    }

    public static void main(String[] args) throws Exception {
        PlayGround instance = new PlayGround();
        System.out.println(instance.power(-2, 4));
    }
}
