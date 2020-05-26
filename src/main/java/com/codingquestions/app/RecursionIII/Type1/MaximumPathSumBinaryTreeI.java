package com.codingquestions.app.RecursionIII.Type1;

import com.codingquestions.app.util.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the
 * maximum possible sum from one leaf node to another leaf node. If there is no
 * such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
 * 
 * Examples
 * 
 * -15
 * 
 * / \
 * 
 * 2 11
 * 
 * / \
 * 
 * 6 14
 * 
 * The maximum path sum is 6 + 11 + 14 = 31.
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

public class MaximumPathSumBinaryTreeI {
    /**
     * What do you expect from lchild and rchild? The max sum of a straight path
     * from a leaf node to the lchild/rchild
     * 
     * What do you do in the current layer? update globalMax with lChildSum +
     * rChildSum + root.key if necessary
     * 
     * What do you return to your parent? 3 cases: both null, return root.key one of
     * them is null, return the non-null one + root.key both of them are not null,
     * return max(lChildSum, rChildSum) + root.key
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

        int lcost = helper(root.left, max);
        int rcost = helper(root.right, max);

        int currSum = lcost + rcost + root.key;

        // update the result only when needed
        // NOTE: we have root.left and root.right check because the
        // question specify that it has froom leaf to leaf and two
        // leaf nodes cannot be the same
        if (max[0] < currSum && (root.left != null && root.right != null)) {
            max[0] = currSum;
        }

        // return the max cost to parent
        if (root.left == null) {
            return root.key + rcost;
        } else if (root.right == null) {
            return root.key + lcost;
        }

        return Math.max(lcost, rcost) + root.key;
    }

}