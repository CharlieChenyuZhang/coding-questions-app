package com.codingquestions.app.RecursionIII.Type1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.codingquestions.app.util.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Determine
 * if there exists a path (the path can only be from one node to itself or to
 * any of its descendants), the sum of the numbers on the path is the given
 * target number.
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 2 11
 * 
 * / \
 * 
 * 6 14
 * 
 * /
 * 
 * 3
 * 
 * If target = 17, There exists a path 11 + 6, the sum of the path is target.
 * 
 * If target = 20, There exists a path 11 + 6 + 3, the sum of the path is
 * target.
 * 
 * If target = 10, There does not exist any paths sum of which is target.
 * 
 * If target = 11, There exists a path only containing the node 11.
 * 
 * How is the binary tree represented?
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

public class BinaryTreePathSumToTargetIII {
    // method 1
    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // pass down the prefix of the path
        List<TreeNode> path = new ArrayList<>();
        return helper(root, path, target);
    }

    private boolean helper(TreeNode root, List<TreeNode> path, int target) {
        path.add(root);
        int tmp = 0;
        // calculate sum backward
        for (int i = path.size() - 1; i >= 0; i--) {
            tmp += path.get(i).key;
            if (tmp == target) {
                return true;
            }
        }

        // NOTE: if I can find it at either left and right path
        // I return true
        if (root.left != null && helper(root.left, path, target)) {
            return true;
        }

        if (root.right != null && helper(root.right, path, target)) {
            return true;
        }
        // NOTE: don't forget for the cleanup when return to the
        // previous level
        path.remove(path.size() - 1);
        return false;
    }

    // method2 [NOTE: recomended, O(n) solution]
    public boolean exist2(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSums = new HashSet<>();
        // NOTE: it's important to add 0 to the prefixSums
        prefixSums.add(0);
        return helperII(root, prefixSums, 0, target);
    }

    private boolean helperII(TreeNode root, Set<Integer> prefixSums, int prevSum, int target) {
        prevSum += root.key;
        if (prefixSums.contains(prevSum - target)) {
            return true;
        }
        boolean needRemove = prefixSums.add(prevSum);

        if (root.left != null && helperII(root.left, prefixSums, prevSum, target)) {
            return true;
        }

        if (root.right != null && helperII(root.right, prefixSums, prevSum, target)) {
            return true;
        }

        // NOTE: I need to make sure prevSum was added in this level
        // that's why I have a needRemove check here !!!
        if (needRemove) {
            prefixSums.remove(prevSum);
        }

        return false;
    }

}