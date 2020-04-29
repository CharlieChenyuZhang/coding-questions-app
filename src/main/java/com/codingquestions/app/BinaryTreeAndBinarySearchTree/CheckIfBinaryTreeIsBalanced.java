package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.util.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 
 */

// Solution:

public class CheckIfBinaryTreeIsBalanced {
    // solution 1:
    // TIME: O(n logn)
    // SPACE: O(n)
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    // +++++++++++++++++++++++++
    // method 2
    // TIME: O(n)
    // SPACE: O(n) // worst case is all nodes are skewed
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        // -1 represents the tree is not balanced
        // >= 0 represents the height of the tree
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0; // represents the height is 0
        }

        int leftHeight = height(root.left);

        // NOTE: this is how you prune earlier
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
