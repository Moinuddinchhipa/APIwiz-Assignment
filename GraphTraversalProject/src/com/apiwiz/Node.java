package com.apiwiz;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Node {
    int id;
    String name;
    List<Node> children = new ArrayList<>();
    List<Node> parents = new ArrayList<>();
    AtomicInteger dependencies = new AtomicInteger(0); // No. of unexecuted parents

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addChild(Node child) {
        this.children.add(child);
        child.parents.add(this);
        child.dependencies.incrementAndGet();
    }
}
