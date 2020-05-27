package com.codingquestions.app.RecursionIII.Type2;

import com.codingquestions.app.util.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the
 * maximum possible path sum from a leaf to root.
 * 
 * 
 * 
 * Assumptions
 * 
 * The root of given binary tree is not null.
 * 
 * 
 * 
 * Examples
 * 
 * 
 * 
 * 10
 * 
 * / \
 * 
 * -2 7
 * 
 * / \
 * 
 * 8 -4
 * 
 * The maximum path sum is 10 + 7 = 17.
 */
public class MaxPathSumFromLeafToRoot {

    /**
     * What do you expect from lchild and rchild? maxSum in that goes through
     * lchild/rchild from root to leaf What do I give to my lchild and rchild?
     * prefix sum from root to till the current node What do you do in the current
     * layer? root.key + prefixsum What do you return to your parent? nothing
     */
    // top down
    public int maxPathSumLeafToRoot(TreeNode root) {
        // assumption root != null
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        sum += root.key;

        // three cases
        if (root.left == null && root.right == null) {
            return sum;
        } else if (root.left == null) {
            return helper(root.right, sum);
        } else if (root.right == null) {
            return helper(root.left, sum);
        }

        return Math.max(helper(root.left, sum), helper(root.right, sum));
    }

    // method2: bottom up return the max suffix sum
    public int maxPathSumLeafToRoot2(TreeNode root) {
        // assumption root != null
        if (root.left == null && root.right == null) {
            return root.key;
        }

        if (root.left == null) {
            return maxPathSumLeafToRoot2(root.right) + root.key;
        }

        if (root.right == null) {
            return maxPathSumLeafToRoot2(root.left) + root.key;
        }
        return Math.max(maxPathSumLeafToRoot2(root.left), maxPathSumLeafToRoot2(root.right)) + root.key;
    }

}