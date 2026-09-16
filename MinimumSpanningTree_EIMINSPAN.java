import java.util.*;

public class MinimumSpanningTree_EIMINSPAN {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            ver[u].addVertex(new Edge(ver[v], w));
            ver[v].addVertex(new Edge(ver[u], w));
        }

        long mst = prim(ver, n);
        System.out.println(mst);
    }

    static long prim(Vertex[] ver, int n) {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(e -> e.length));
        q.add(new Edge(ver[0], 0));
        int count = 0;
        long total = 0;
        while (!q.isEmpty()) {
            Edge adj = q.poll();
            if (adj.vertex.visited) {
                continue;
            }
            adj.vertex.visited = true;
            total += adj.length;
            count++;

            for (Edge v : adj.vertex.adjacent) {
                if (!v.vertex.visited) {
                    q.add(v);
                }
            }
        }

        return count == n ? total : -1;
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