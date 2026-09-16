import java.util.*;

public class Topologicalorder_TOPOORDER {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] ver = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].indegree++;
        }

        for (Vertex v : ver) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
        }

        int count = bfs(ver);
        if (count != n) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static int bfs(Vertex[] ver) {
        Queue<Vertex> q = new ArrayDeque<>();
        for (Vertex u : ver) {
            if (u.indegree == 0) {
                q.add(u);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            Vertex adj = q.poll();
            sb.append(adj.id).append(" ");
            count++;

            for (Vertex v : adj.adjacent) {
                v.indegree--;
                if (v.indegree == 0) {
                    q.add(v);
                }
            }
        }
        return count;
    }

    static class Vertex {
        int id;
        int indegree = 0;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}