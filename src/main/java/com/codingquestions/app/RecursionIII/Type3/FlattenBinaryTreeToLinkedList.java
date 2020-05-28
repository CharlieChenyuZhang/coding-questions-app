package com.codingquestions.app.RecursionIII.Type3;

import com.codingquestions.app.util.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 * 1 / \ 2 5 / \ \ 3 4 6 The flattened tree should look like:
 * 
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6
 * 
 */
public class FlattenBinaryTreeToLinkedList {
    // method 1
    public TreeNode flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
        return root;
    }

    private void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        helper(root.right, prev);
        helper(root.left, prev);

        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    // method 2
    public TreeNode flatten2(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper2(root, prev);
        return root;
    }

    private void helper2(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (prev[0] == null) {
            prev[0] = root;
        } else {
            prev[0].right = root;
            prev[0].left = null;
            prev[0] = root;
        }

        helper2(left, prev);
        helper2(right, prev);
    }
}