package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.utils.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

// Problem:
/**
 *
 */

// Solution:
// TIME:
// SPACE:
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
}
