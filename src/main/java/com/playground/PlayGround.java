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

public class PlayGround {
    public class Employee {
        private final String name = "charlie";
        private final String id = "1";
        private int age;
        protected int salary;
        protected int level;
        int test = 1;
        public int test2 = 2;

        public void printInfo() {
            System.out.println("Name: " + name + age + id);
        }
    }

    public class Manager extends Employee {
        public Manager() {

        }

        public void xxx() {
            // System.out.println(salary);
            // printInfo();

            Employee e = new Employee();
            System.out.println(e.name); // FIXME:

            // Manager m = new Manager();
            // System.out.println(m.name + m.id + m.id + m.salary);{
        }
    }

    public static void main(String[] args) {
        PlayGround pg = new PlayGround();
        Manager m = pg.new Manager();
        m.xxx();
    }

}