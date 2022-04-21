package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.util.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Problem:
/**
 * Implement an iterative, post-order traversal of a given binary tree, return
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
// SPACE: O(height) if we didn't count the space used to stroe the result
public class PostorderTraversalOfBinaryTreeIiterative {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            // note: this is comparing the reference
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    result.add(curr.key);
                    stack.pollFirst();
                }
            } else if (prev == curr.left) {
                if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    result.add(curr.key);
                    stack.pollFirst();
                }
            } else {
                result.add(curr.key);
                stack.pollFirst();
            }
            prev = curr;
        }
        return result;
    }

    // method 2: notice that postOrder is the reverse of inOrder that explores the
    // right sub-tree first
    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            result.add(cur.key);

            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }

        }

        Collections.reverse(result);
        return result;
    }
}
