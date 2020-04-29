package com.codingquestions.app.HeapandGraphSearchBFS;

import com.codingquestions.app.util.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Get the list of list of keys in a given binary tree layer by layer. Each
 * layer is represented by a list of keys and the keys are traversed from left
 * to right.
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
 * the result is [ [5], [3, 8], [1, 4, 11] ]
 * 
 * Corner Cases
 * 
 * What if the binary tree is null? Return an empty list of list in this case.
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

// TIME: O(n)
// SPACE: O(n)
public class GetKeysInBinaryTreeLayerByLayer {
    // BTS1
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int numberOfNodesInThisLayer = queue.size();

            List<Integer> layer = new ArrayList<>();

            for (int i = 0; i < numberOfNodesInThisLayer; i++) {
                // expand + generate
                TreeNode curr = queue.poll();
                layer.add(curr.key);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            result.add(layer);
        }
        return result;
    }

}