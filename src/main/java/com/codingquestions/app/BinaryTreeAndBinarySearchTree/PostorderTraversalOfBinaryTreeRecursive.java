package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.util.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Problem:
/**
 * Implement a recursive, post-order traversal of a given binary tree, return
 * the list of keys of each node in the tree as it is post-order traversed.
 * 
 * Examples
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
 * Post-order traversal is [1, 4, 3, 11, 8, 5]
 * 
 * Corner Cases
 * 
 * What if the given binary tree is null? Return an empty list in this case. How
 * is the binary tree represented?
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

// Solution:
// TIME: O(n)
// SPACE: O(height)
public class PostorderTraversalOfBinaryTreeRecursive {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postOrderHelper(root, result);
        return result;
    }

    private void postOrderHelper(TreeNode root, List<Integer> result) {

        // base case
        if (root == null) {
            return;
        }

        postOrderHelper(root.left, result);
        postOrderHelper(root.right, result);
        result.add(root.key);
    }

}
