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

public class PlayGround {

    public static void main(String[] args) {
        Person p = new Employee();
        String company = ((Employee) p).getCompany();
        System.out.println(company);
    }
}
