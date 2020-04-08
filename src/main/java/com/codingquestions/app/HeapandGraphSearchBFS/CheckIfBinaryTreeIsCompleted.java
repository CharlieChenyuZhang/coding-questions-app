package com.codingquestions.app.HeapandGraphSearchBFS;

import com.codingquestions.app.utils.TreeNode;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * Check if a given binary tree is completed. A complete binary tree is one in
 * which every level of the binary tree is completely filled except possibly the
 * last level. Furthermore, all nodes are as far left as possible.
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 3 8
 * 
 * / \
 * 
 * 1 4
 * 
 * is completed.
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
 * is not completed.
 * 
 * Corner Cases
 * 
 * What if the binary tree is null? Return true in this case. How is the binary
 * tree represented?
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

// TIME: O(n)
// SPACE: O(1)
public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }

        // indivate whether we have seen a null
        boolean flag = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(curr.left);
            }

            if (curr.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(curr.right);
            }

        }
        return true;
    }

}