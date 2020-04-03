package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

// Problem:
/**
 * Implement an iterative, pre-order traversal of a given binary tree, return
 * the list of keys of each node in the tree as it is pre-order traversed.
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
 * Pre-order traversal is [5, 3, 1, 4, 8, 11]
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
 * 
 */

// Solution:
// TIME: O(n)
// SPACE: O(n) if I am storing the result. O(height) if not storing the result.
public class PreorderTraversalOfBinaryTreeIiterative {
    public List<Integer> preOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            result.add(curr.key);
            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }

            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
        }
        return result;
    }

}
