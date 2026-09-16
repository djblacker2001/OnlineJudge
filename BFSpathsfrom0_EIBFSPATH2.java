import java.util.*;

public class BFSpathsfrom0_EIBFSPATH2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Vertex ver[] = new Vertex[n];
        Vertex parent[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        for (Vertex v : ver) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
        }

        bfs(ver[0], parent);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (!ver[x].visited) {
                sb.append(-1).append("\n");
            } else {
                printPath(ver[x], parent);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static void bfs(Vertex u, Vertex parent[]) {
        Queue<Vertex> q = new ArrayDeque<>();
        q.add(u);
        u.visited = true;
        while (!q.isEmpty()) {
            Vertex adj = q.poll();
            for (Vertex v : adj.adjacent) {
                if (!v.visited) {
                    v.visited = true;
                    parent[v.id] = adj;
                    q.add(v);
                }
            }
        }
    }

    static void printPath(Vertex u, Vertex parent[]) {
        if (parent[u.id] != null) {
            printPath(parent[u.id], parent);
            sb.append("->");
        }
        sb.append(u.id);
    }

    static class Vertex {
        int id;
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