package com.codingquestions.app.HeapandGraphSearchBFS;

import com.codingquestions.app.util.GraphNode;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Determine if an undirected graph is bipartite. A bipartite graph is one in
 * which the nodes can be divided into two groups such that no nodes have direct
 * edges to other nodes in the same group.
 * 
 * Examples
 * 
 * 1 -- 2
 * 
 * /
 * 
 * 3 -- 4
 * 
 * is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 * 
 * 1 -- 2
 * 
 * / |
 * 
 * 3 -- 4
 * 
 * is not bipartite.
 * 
 * Assumptions
 * 
 * The graph is represented by a list of nodes, and the list of nodes is not
 * null.
 */

// TIME: O(nodes + number of edges in total)
// SPACE: O(n)
public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // use 0 and 1 to denote two different groups
        // the hashMap trakcs for each node which group it belogs to
        HashMap<GraphNode, Integer> visited = new HashMap<>();

        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        // if node has been traversed, no need to do BFS again
        if (visited.containsKey(node)) {
            return true;
        }

        // this is the queue to store the GraphNode to expand next
        Queue<GraphNode> queue = new ArrayDeque<>();

        queue.offer(node);
        // since the node has not been visited,
        // we can assign it to any groups
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode curr = queue.poll();
            int currGroup = visited.get(curr);
            int neighborGroup = currGroup == 1 ? 0 : 1;
            for (GraphNode nei : curr.neighbors) {
                // if the neighbor has not been visited
                // just put it in the queue and
                // assign it to the correct group
                if (!visited.containsKey(nei)) {
                    queue.offer(nei);
                    visited.put(nei, neighborGroup);
                } else if (visited.get(nei) != neighborGroup) {
                    // if the nei has been visited
                    // if its group assigned doesn’t
                    // match ours, return False
                    return false;
                }
            }
        }
        return true;

    }

}