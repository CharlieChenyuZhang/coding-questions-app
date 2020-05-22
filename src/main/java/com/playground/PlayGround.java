package com.playground;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
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

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class GreenApple extends Apple {
    }

    private static void print(String[] input) {
        for (String each : input) {
            System.out.println(each);
        }
    }

    public static void main(String[] args) throws Exception, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        sb.append('b');
        sb.append('c');

        System.out.println(sb.delete(sb.length() - 2, sb.length()));
        System.out.println(sb);

    }
}
