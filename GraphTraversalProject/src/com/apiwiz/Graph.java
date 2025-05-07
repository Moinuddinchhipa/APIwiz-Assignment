package com.apiwiz;

import java.util.*;
import java.util.concurrent.*;

public class Graph {
    Map<Integer, Node> nodeMap = new HashMap<>();
    ExecutorService executor = Executors.newCachedThreadPool();
    Set<Integer> visited = ConcurrentHashMap.newKeySet();
    CountDownLatch latch;

    public void addNode(int id, String name) {
        nodeMap.put(id, new Node(id, name));
    }

    public void addEdge(int from, int to) {
        Node parent = nodeMap.get(from);
        Node child = nodeMap.get(to);
        parent.addChild(child);
    }

    public void traverseFromRoot() throws InterruptedException {
        latch = new CountDownLatch(nodeMap.size());
        traverse(nodeMap.get(1));
        latch.await(); // Wait for all tasks
        executor.shutdown();
        System.out.println(nodeMap.size());
    }

    private void traverse(Node node) {
        if (visited.contains(node.id)) return;

        executor.submit(() -> {
            try {
                while (node.dependencies.get() > 0) {
                    Thread.sleep(10); // Wait for all parents
                }

                if (visited.add(node.id)) {
                    System.out.println(node.name);
                    latch.countDown();

                    for (Node child : node.children) {
                        child.dependencies.decrementAndGet();
                        traverse(child);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
