import java.util.*;

public class GroupingVertices_EIMAXGRP {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> currentGroup;
    static ArrayList<Integer> largestGroup;
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] ver = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < n; i++) {
            ver[i].value = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        largestGroup = new ArrayList<>();
        for (Vertex v : ver) {
            if (!v.visited) {
                currentGroup = new ArrayList<>();
                dfs(v);
                if (currentGroup.size() > largestGroup.size()) {
                    largestGroup = currentGroup;
                }
            }
        }

        for (int x : largestGroup) {
            System.out.print(x + " ");
        }
    }

    static void dfs(Vertex u) {
        u.visited = true;
        currentGroup.add(u.id);
        for (Vertex v : u.adjacent) {
            if (!v.visited && v.value == u.value) {
                dfs(v);
            }
        }
    }

    static class Vertex {
        int id;
        int value;
        boolean visited;
        List<Vertex> adjacent = new ArrayList<>();
        
        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}