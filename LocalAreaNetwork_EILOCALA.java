import java.util.*;

public class LocalAreaNetwork_EILOCALA {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            ver[u].adjacent.add(new Edge(ver[v], w));
            ver[v].adjacent.add(new Edge(ver[u], w));
        }

        dfs(ver[0]);
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (ver[i].maxdistance > ver[a].maxdistance) {
                a = i;
            }
        }
        reset(ver);
        dfs(ver[a]);
        int b = a;
        for (int i = 0; i < n; i++) {
            if (ver[i].maxdistance > ver[b].maxdistance) {
                b = i;
            }
        }

        sb.append(Math.min(a, b)).append(" ").append(ver[b].maxdistance);
        System.out.println(sb);
    }

    static void dfs(Vertex u) {
        u.visited = true;
        for (Edge v : u.adjacent) {
            if (!v.vertex.visited) {
                v.vertex.maxdistance = u.maxdistance + v.length;
                dfs(v.vertex);
            }
        }
    }

    static void reset(Vertex ver[]) {
        for (int i = 0; i < ver.length; i++) {
            ver[i].visited = false;
            ver[i].maxdistance = 0;
        }
    }

    static class Edge {
        Vertex vertex;
        int length;

        public Edge(Vertex vertex, int length) {
            this.vertex = vertex;
            this.length = length;
        }
    }

    static class Vertex {
        int id;
        int maxdistance;
        boolean visited = false;
        List<Edge> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Edge v) {
            adjacent.add(v);
        }
    }
}