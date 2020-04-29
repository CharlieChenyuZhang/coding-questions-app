package com.codingquestions.app.BinaryTreeAndBinarySearchTree;

import com.codingquestions.app.util.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

// Problem:
/**
 * Delete the target key K in the given binary search tree if the binary search
 * tree contains K. Return the root of the binary search tree.
 * 
 * Find your own way to delete the node from the binary search tree, after
 * deletion the binary search tree's property should be maintained.
 * 
 * Assumptions
 * 
 * There are no duplicate keys in the binary search tree
 * 
 * The smallest larger node is first candidate after deletion
 */

// Solution:
// TIME: O(height)
// SPACE: O(height)
public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.key == key) {
            // case 1 & 2
            if (root.left == null) {
                return root.right;
                // case 3
            } else if (root.right == null) {
                return root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newRoot = deleteSmallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        } else if (key > root.key) {
            root.right = deleteTree(root.right, key);
        } else {
            root.left = deleteTree(root.left, key);
        }
        return root;
    }

    private TreeNode deleteSmallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }

        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }
}
