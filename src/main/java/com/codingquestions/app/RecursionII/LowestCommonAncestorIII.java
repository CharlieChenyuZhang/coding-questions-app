package com.codingquestions.app.RecursionII;

import com.codingquestions.app.util.TreeNode;
/**
 * Given two nodes in a binary tree, find their lowest common ancestor (the
 * given two nodes are not guaranteed to be in the binary tree).
 * 
 * Return null If any of the nodes is not in the tree.
 * 
 * Assumptions
 * 
 * There is no parent pointer for the nodes in the binary tree
 * 
 * The given two nodes are not guaranteed to be in the binary tree
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
 * 
 * The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */

// TIME:
// SPACE:
/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        TreeNode lca = findLCA(root, one, two);
        return postprocessing(lca, root, one, two);

    }

    private TreeNode postprocessing(TreeNode lca, TreeNode root, TreeNode one, TreeNode two) {
        // when LCA is one or two
        // case 1: both one and two exist and they are in same path
        // case 2:
        // case 2.1 if returns one, two might not be in the tree
        // case 2.2 if returns two, one might not be in the tree

        if (lca == null) {
            return lca;
        }

        if (lca == one) {
            TreeNode findTwo = findLCA(root, two, two);
            if (findTwo != null) {
                return lca;
            } else {
                return null;
            }
        }

        if (lca == two) {
            TreeNode findOne = findLCA(root, one, one);
            if (findOne != null) {
                return lca;
            } else {
                return null;
            }
        }

        return lca;
    }

    private TreeNode findLCA(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }

        if (root == one || root == two) {
            return root;
        }

        TreeNode left = findLCA(root.left, one, two);
        TreeNode right = findLCA(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

}