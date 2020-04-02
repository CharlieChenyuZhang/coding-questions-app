package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

// Problem:
/**
 * Insert a key in a binary search tree if the binary search tree does not
 * already contain the key. Return the root of the binary search tree.
 * 
 * Assumptions
 * 
 * There are no duplicate keys in the binary search tree
 * 
 * If the key is already existed in the binary search tree, you do not need to
 * do anything
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 3 8
 * 
 * / \
 * 
 * 1 4
 * 
 * insert 11, the tree becomes
 * 
 * 5
 * 
 * / \
 * 
 * 3 8
 * 
 * / \ \
 * 
 * 1 4 11
 * 
 * insert 6, the tree becomes
 * 
 * 5
 * 
 * / \
 * 
 * 3 8
 * 
 * / \ / \
 * 
 * 1 4 6 11
 */

// Solution:
public class InsertInBinarySearchTree {
    // recursive
    // TIME: O(height)
    // SPACE: O(height)
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key == root.key) {
            return root;
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }

        return root;
    }

    // iterative
    // TIME: O(height)
    // SPACE: O(1)
    public TreeNode insert2(TreeNode root, int key) {

        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.key == key) {
                break;
            }

            if (key > curr.key) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }

        // I want to exist whenever curr == null
        // or we find the node to insert it to
        // post-processing
        if (prev == null) {
            return new TreeNode(key);
        } else if (key > prev.key) {
            prev.right = new TreeNode(key);
        } else {
            prev.left = new TreeNode(key);
        }
        return root;

    }

}
