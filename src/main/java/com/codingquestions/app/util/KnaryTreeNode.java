package com.codingquestions.app.util;

import java.util.List;
import java.util.ArrayList;

public class KnaryTreeNode {
    public int key;
    public List<KnaryTreeNode> children;

    public KnaryTreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
}