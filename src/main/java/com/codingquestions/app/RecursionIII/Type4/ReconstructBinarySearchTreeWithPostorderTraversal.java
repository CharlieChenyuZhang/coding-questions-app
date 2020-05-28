package com.codingquestions.app.RecursionIII.Type4;

import com.codingquestions.app.util.TreeNode;

/**
 * Given the postorder traversal sequence of a binary search tree, reconstruct
 * the original tree.
 * 
 * Assumptions
 * 
 * The given sequence is not null There are no duplicate keys in the binary
 * search tree Examples
 * 
 * postorder traversal = {1, 4, 3, 11, 8, 5}
 * 
 * the corresponding binary search tree is
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
 * How is the binary tree represented?
 * 
 * We use the pre order traversal sequence with a special symbol "#" denoting
 * the null node.
 * 
 * For Example:
 * 
 * The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary
 * tree:
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

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        return helper(post, 0, post.length - 1);
    }

    private TreeNode helper(int[] post, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }

        // recursive rule
        TreeNode root = new TreeNode(post[right]);
        int leftSize = getLeftSize(post, left, right, root.key);
        root.left = helper(post, left, left + leftSize - 1);
        root.right = helper(post, left + leftSize, right - 1);
        return root;
    }

    private int getLeftSize(int[] post, int left, int right, int rootValue) {
        int size = 0;
        for (int i = left; i <= right; i++) {
            if (post[i] < rootValue) {
                size++;
            } else {
                break;
            }
        }
        return size;
    }

}