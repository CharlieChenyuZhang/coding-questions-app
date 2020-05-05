package com.codingquestions.app.RecursionII;

import java.util.List;

import com.codingquestions.app.util.TreeNode;

/**
 * Given K nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * 
 * K >= 2
 * 
 * There is no parent pointer for the nodes in the binary tree
 * 
 * The given K nodes are guaranteed to be in the binary tree
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
 * The lowest common ancestor of 2, 3, 14 is 5
 * 
 * The lowest common ancestor of 2, 3, 9 is 9
 */

/**
 * what do I expect from my lchild and rchild? either one of the k nodes or the
 * LCA
 * 
 * What do I do in the current layer? nothing
 * 
 * what do I return to my parent? case 1: if root matches either of my nodes in
 * the list → return root case 2: if both lchild and rchild are null → return
 * null case 3: if both lchild and rchild are not null → return root case 4: if
 * either lchild and rchild are not null → return the non-null one
 * 
 */
public class LowestCommonAncestorIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return null;
        }

        if (nodes.contains(root)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}