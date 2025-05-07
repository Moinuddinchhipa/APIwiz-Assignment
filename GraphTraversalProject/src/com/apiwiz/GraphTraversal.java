package com.apiwiz;

import java.util.Scanner;

public class GraphTraversal {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Graph graph = new Graph();

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(":");
            graph.addNode(Integer.parseInt(parts[0]), parts[1]);
        }

        int M = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < M; i++) {
            String[] edge = sc.nextLine().split(":");
            graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

        graph.traverseFromRoot();
        sc.close();
    }
}
