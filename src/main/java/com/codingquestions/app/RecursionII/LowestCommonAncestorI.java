package com.codingquestions.app.RecursionII;

import com.codingquestions.app.util.TreeNode;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * 
 * There is no parent pointer for the nodes in the binary tree
 * 
 * The given two nodes are guaranteed to be in the binary tree
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 9 12
 * 
 * / \ \
 * 
 * 2 3 14
 * 
 * The lowest common ancestor of 2 and 14 is 5
 * 
 * The lowest common ancestor of 2 and 9 is 9
 */
/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */
public class LowestCommonAncestorI {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return root;
        }

        if (root.key == one.key || root.key == two.key) {
            return root.key == one.key ? one : two;
        }

        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }

}