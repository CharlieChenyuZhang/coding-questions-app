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
// TIME: O(n)
// SPACE: O(n) if I store the result array, if not storing the result array,
// O(height)
public class InorderTraversalOfBinaryTreeIiterative {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // helper is used for two things
        // first, if not null, it points to the next node to reverse
        // second, if null, it points to the node which left subtree
        // have all been printed
        TreeNode helper = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (helper != null || !stack.isEmpty()) {
            if (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            }

            if (helper == null) {
                helper = stack.pollFirst();
                result.add(helper.key);
                helper = helper.right;
            }
        }

        return result;
    }

}
