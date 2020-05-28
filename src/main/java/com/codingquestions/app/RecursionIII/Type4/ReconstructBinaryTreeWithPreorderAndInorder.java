package com.codingquestions.app.RecursionIII.Type4;

import java.util.HashMap;
import java.util.Map;

import com.codingquestions.app.util.TreeNode;

/**
 * Given the preorder and inorder traversal sequence of a binary tree,
 * reconstruct the original tree.
 * 
 * Assumptions
 * 
 * The given sequences are not null and they have the same length There are no
 * duplicate keys in the binary tree Examples
 * 
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 * 
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 * 
 * the corresponding binary tree is
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
 * How is the binary tree represented?
 * 
 * We use the pre order traversal sequence with a special symbol "#" denoting
 * the null node.
 * 
 * For Example:
 * 
 * The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
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
public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] in, int[] pre) {
        // assumptions: pre, in are not null, there is no duplicates
        // in the binary tree, the length of pre and in are guarenteed
        // to be the same
        Map<Integer, Integer> inIndex = indexMap(in);
        return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }

    private Map<Integer, Integer> indexMap(int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }

    // [inLeft, inRight], [preLeft, preRight]
    private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft,
            int preRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int inMid = inIndex.get(root.key);
        int leftSize = inMid - inLeft;
        root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + leftSize);
        root.right = helper(pre, inIndex, inMid + 1, inRight, preLeft + leftSize + 1, preRight);
        return root;
    }

}