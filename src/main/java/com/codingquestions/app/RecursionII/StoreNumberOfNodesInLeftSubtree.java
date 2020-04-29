package com.codingquestions.app.RecursionII;

import com.codingquestions.app.util.TreeNodeLeft;

/**
 * Given a binary tree, count the number of nodes in each node’s left subtree,
 * and store it in the numNodesLeft field.
 * 
 * Examples
 * 
 * 
 * 
 * 1(6)
 * 
 * / \
 * 
 * 2(3) 3(0)
 * 
 * / \
 * 
 * 4(1) 5(0)
 * 
 * / \ \
 * 
 * 6(0) 7(0) 8(0)
 * 
 * The numNodesLeft is shown in parentheses.
 */

// TIME: O(n)
// SPACE: O(height)
public class StoreNumberOfNodesInLeftSubtree {
    public void numNodesLeft(TreeNodeLeft root) {
        helper(root);
    }

    private int helper(TreeNodeLeft root) {
        // base case
        if (root == null) {
            return 0;
        }

        int nodesInLeftSubtree = helper(root.left);
        int nodesInRightSubtree = helper(root.right);

        root.numNodesLeft = nodesInLeftSubtree;
        return nodesInLeftSubtree + nodesInRightSubtree + 1;
    }

}