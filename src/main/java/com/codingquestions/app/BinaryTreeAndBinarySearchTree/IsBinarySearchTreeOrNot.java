package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.util.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * Determine if a given binary tree is binary search tree.There should no be
 * duplicate keys in binary search tree.
 * 
 * Assumptions
 * 
 * You can assume the keys stored in the binary search tree can not be
 * Integer.MIN_VALUE or Integer.MAX_VALUE. Corner Cases
 * 
 * What if the binary tree is null? Return true in this case.
 */

// Solution:
// TIME: O(n)
// SPACE: O(height)
public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode root, int min, int max) {
        // base case
        if (root == null) {
            return true;
        } else if (root.key >= max || root.key <= min) {
            return false;
        }

        // recursive rule
        return isBSTHelper(root.left, min, root.key) && isBSTHelper(root.right, root.key, max);
    }
}
