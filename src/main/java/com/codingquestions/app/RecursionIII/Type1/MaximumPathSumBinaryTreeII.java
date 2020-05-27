package com.codingquestions.app.RecursionIII.Type1;

import com.codingquestions.app.util.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the
 * maximum possible sum from any node to any node (the start node and the end
 * node can be the same).
 * 
 * Assumptions
 * 
 * ​The root of the given binary tree is not null Examples
 * 
 * -1
 * 
 * / \
 * 
 * 2 11
 * 
 * / \
 * 
 * 6 -14
 * 
 * one example of paths could be -14 -> 11 -> -1 -> 2
 * 
 * another example could be the node 11 itself
 * 
 * The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
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

public class MaximumPathSumBinaryTreeII {
    /**
     * What do you expect from lchild and rchild? max sum in a straight path
     * includes lchild/rchild What do you do in the current layer? update global max
     * using max(lchild, 0) + max(rchild,0) + root.key
     * 
     * What do you return to your parent? max(lchild, rchild) + root.key
     */

    public int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(max[0], left + right + root.key);
        return root.key + Math.max(left, right);
    }

}