package com.codingquestions.app.HeapandGraphSearchBFS;

import java.util.List;

import com.codingquestions.app.util.GraphNode;

/** visit every node in the graph */

// TIME: O (V + E)
/**
 * This is how to analyze the time complexity. Although it seems that we have
 * nested for loops, but when <1> increases <2> will decreases. For example,
 * when <1> has n iterations, <2> will have 0 In this case, we need to find the
 * invariant.
 * 
 * Invariant in our case is the number of calls to the function dfs and it's N
 * times average neighbors/edges is E / V
 * 
 * So total time complexity is O(V * (1 + E / V)) = O(E + V)
 * 
 */
public class GraphVisiter {
    public void traverse(List<GraphNode> graph) {
        for (GraphNode node : graph) { // <1>
            if (!node.visited) {
                dfs(node);
            }
        }
    }

    private void dfs(GraphNode node) { // invariant
        node.visited = true;
        for (GraphNode nei : node.neighbors) { // <2>
            if (!nei.visited) {
                dfs(nei);
            }
        }
    }
}