package com.codingquestions.app.util;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public boolean visited;

    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
        this.visited = false;
    }

}