package com.codingquestions.app.RecursionIII.Type4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingquestions.app.util.TreeNode;

/**
 * Given the levelorder and inorder traversal sequence of a binary tree,
 * reconstruct the original tree.
 * 
 * Assumptions
 * 
 * The given sequences are not null and they have the same length There are no
 * duplicate keys in the binary tree Examples
 * 
 * levelorder traversal = {5, 3, 8, 1, 4, 11}
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
 * We use level order traversal sequence with a special symbol "#" denoting the
 * null node.
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

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> inMap = buildMap(inOrder);
        List<Integer> list = buildList(levelOrder);

        return helper(list, inMap);
    }

    private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap) {
        if (level.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(level.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : level) {
            if (inMap.get(num) < inMap.get(root.key)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        root.left = helper(left, inMap);
        root.right = helper(right, inMap);
        return root;
    }

    private Map<Integer, Integer> buildMap(int[] array) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            inMap.put(array[i], i);
        }
        return inMap;
    }

    private List<Integer> buildList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int ele : array) {
            list.add(ele);
        }
        return list;
    }

}