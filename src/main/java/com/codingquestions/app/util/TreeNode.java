package com.codingquestions.app.util;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    // TODO:
    public TreeNode buildTree(int[] list) {
        return new TreeNode(0);
    }

    // TODO: print out a tree
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        return "";
    }
}