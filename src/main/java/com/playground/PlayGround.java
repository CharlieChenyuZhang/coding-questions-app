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

class Parent {
    int age;

    public Parent(int age) {
        this.age = age;
    }

    public void sayName() {
        System.out.println("my name is Charlie");
    }
}

class Child extends Parent {
    public Child(int age) {
        super(age);
    }

}

public class PlayGround {

    public static void main(String[] args) {
        Child instance = new Child(12);
        instance.sayName();
    }
}