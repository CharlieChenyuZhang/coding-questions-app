package com.codingquestions.app.RecursionII;

import com.codingquestions.app.util.KnaryTreeNode;
import java.util.List;

/**
 * Given M nodes in a K-nary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * 
 * - M >= 2.
 * 
 * - There is no parent pointer for the nodes in the K-nary tree.
 * 
 * - The given M nodes are guaranteed to be in the K-nary tree.
 * 
 * Examples
 * 
 * 5
 * 
 * / \
 * 
 * 9 12
 * 
 * / | \ \
 * 
 * 1 2 3 14
 * 
 * 
 * 
 * The lowest common ancestor of 2, 3, 14 is 5.
 * 
 * The lowest common ancestor of 2, 3, 9 is 9.
 */

public class LowestCommonAncestorVI {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        if (root == null) {
            return null;
        }

        if (nodes.contains(root)) {
            return root;
        }

        KnaryTreeNode found = null;

        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode childLCA = lowestCommonAncestor(child, nodes);
            if (childLCA == null) {
                continue;
            }

            if (found != null) {
                return root;
            } else {
                found = childLCA;
            }
        }
        return found;
    }

}