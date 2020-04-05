package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * Check if a given binary tree is symmetric.
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 3 3
 * 
 * / \ / \
 * 
 * 1 4 4 1
 * 
 * is symmetric.
 * 
 * 5
 * 
 * / \
 * 
 * 3 3
 * 
 * / \ / \
 * 
 * 1 4 1 4
 * 
 * is not symmetric.
 * 
 * Corner Cases
 * 
 * What if the binary tree is null? Return true in this case. How is the binary
 * tree represented?
 * 
 * We use the level order traversal sequence with a special symbol "#" denoting
 * the null node.
 * 
 * For Example:
 * 
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * /
 * 
 * 4
 */

// Solution:
// TIME: O(n)
// SPACE: O(height)
public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.key != right.key) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
