package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * Determine whether two given binary trees are identical assuming any number of
 * ‘tweak’s are allowed. A tweak is defined as a swap of the children of one
 * node in the tree.
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
 * and
 * 
 * 5
 * 
 * / \
 * 
 * 8 3
 * 
 * / \
 * 
 * 1 4
 * 
 * the two binary trees are tweaked identical.
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
 */

// Solution:
// TIME: O(n^2)
// SPACE: O(log n)
public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }

        return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left)
                || isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
    }
}
