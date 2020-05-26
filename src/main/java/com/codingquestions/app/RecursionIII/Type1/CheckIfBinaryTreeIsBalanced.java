package com.codingquestions.app.RecursionIII.Type1;

import com.codingquestions.app.util.TreeNode;

/**
 * Check if a given binary tree is balanced. A balanced binary tree is one in
 * which the depths of every node’s left and right subtree differ by at most 1.
 * 
 * Examples
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
 * is balanced binary tree,
 * 
 * 5
 * 
 * /
 * 
 * 3
 * 
 * / \
 * 
 * 1 4
 * 
 * is not balanced binary tree.
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

public class CheckIfBinaryTreeIsBalanced {
    /**
     * What do you expect from lchild and rchild? >= 0 height -1 represents that
     * it's not balanced
     * 
     * What do you do in the current layer? nothing
     * 
     * What do you return to your parent? return -1 if not balanced, otherwise the
     * height
     */

    // TIME：O(n)
    // SPACE: O(height)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root) == -1 ? false : true;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}