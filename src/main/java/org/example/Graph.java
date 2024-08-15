package org.example;

import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int n : adj[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int n : adj[node]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (Integer i : adj[v]) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.print("BFS: ");
        graph.BFS(0);

        System.out.print("DFS: ");
        graph.DFS(0);

        System.out.println("Graph contains cycle: " + graph.isCyclic());
    }
}
