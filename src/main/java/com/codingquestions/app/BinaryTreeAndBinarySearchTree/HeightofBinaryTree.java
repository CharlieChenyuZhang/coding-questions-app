package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * Find the height of binary tree.
 * 
 * Examples:
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
 * The height of above binary tree is 3.
 * 
 * How is the binary tree represented?
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
 * 
 */

// Solution:
// TIME: O(n)
// SPACE: O(height)
public class HeightofBinaryTree {
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

}
