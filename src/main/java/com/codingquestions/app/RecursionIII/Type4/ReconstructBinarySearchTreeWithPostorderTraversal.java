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

    // method 2 [not required for interview]
    public TreeNode reconstruct2(int[] post) {
        int[] index = new int[] { post.length - 1 };
        return helper2(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper2(int[] postorder, int[] index, int min) {
        if (index[0] < 0 || postorder[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index[0]--]);
        root.right = helper2(postorder, index, root.key); // valid root.right shuld be greater than root.key
        root.left = helper2(postorder, index, min); // valid root.left should be greater than previous min
        return root;
    }

    public static void main(String[] args) {
        ReconstructBinarySearchTreeWithPostorderTraversal instance = new ReconstructBinarySearchTreeWithPostorderTraversal();
        instance.reconstruct2(new int[] { 3, 8, 5 });
    }
}