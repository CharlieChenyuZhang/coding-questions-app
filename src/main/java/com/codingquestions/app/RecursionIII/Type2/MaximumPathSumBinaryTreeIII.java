package com.codingquestions.app.RecursionIII.Type2;

import com.codingquestions.app.util.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the
 * maximum possible subpath sum(both the starting and ending node of the subpath
 * should be on the same path from root to one of the leaf nodes, and the
 * subpath is allowed to contain only one node).
 * 
 * Assumptions
 * 
 * The root of given binary tree is not null Examples
 * 
 * -5
 * 
 * / \
 * 
 * 2 11
 * 
 * / \
 * 
 * 6 14
 * 
 * /
 * 
 * -3
 * 
 * The maximum path sum is 11 + 14 = 25
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

public class MaximumPathSumBinaryTreeIII {
    // method 1: post order
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

        int sum = Math.max(Math.max(left, right), 0) + root.key;
        max[0] = Math.max(max[0], sum);
        return sum;
    }

    // method 2: preorder
    public int maxPathSum2(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };
        helper2(root, max, 0);
        return max[0];
    }

    private void helper2(TreeNode root, int[] max, int prefixSum) {
        if (root == null) {
            return;
        }

        prefixSum = prefixSum < 0 ? root.key : root.key + prefixSum;
        max[0] = Math.max(max[0], prefixSum);
        helper2(root.left, max, prefixSum);
        helper2(root.right, max, prefixSum);
    }

}