package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

// Problem:
/**
 * Find the target key K in the given binary search tree, return the node that
 * contains the key if K is found, otherwise return null.
 * 
 * Assumptions
 * 
 * There are no duplicate keys in the binary search tree
 */

// Solution:
public class SearchInBinarySearchTree {

    // recursion
    // TIME: O(height)
    // SPACE: O(height)
    public TreeNode search1(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.key == target) {
            return root;
        }

        return search1(target > root.key ? root.right : root.left, target);
    }

    // iterative
    // TIME: O(height)
    // SPACE: O(1)
    public TreeNode search2(TreeNode root, int target) {
        while (root != null && root.key != target) {
            root = target > root.key ? root.right : root.left;
        }
        return root;
    }

}
