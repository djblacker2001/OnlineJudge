import java.util.*;

public class MinDistancetoVertices_EIMINDISTA {
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
            ver[u].addVertex(ver[v], w);
            ver[v].addVertex(ver[u], w);
        }

        ver[0].cost = 0;
        findShortPathUsingDijkstra2(ver);
        printDistance(ver);
    }

    private static void findShortPathUsingDijkstra2(Vertex[] vertices) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(vertices[0]);
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            Vertex origin = vertices[minVertex.id];
            if (origin.visited) {
                continue;
            }
            origin.visited = true;
            for (Edge e : origin.adjacentVertices) {
                Vertex v = e.endpoint;
                int w = e.weight;
                if (!v.visited && v.cost > origin.cost + w) {
                    v.cost = origin.cost + w;
                    Vertex clone = new Vertex(v.id);
                    clone.cost = v.cost;
                    queue.add(clone);
                }
            }
        }
    }

    private static void printDistance(Vertex[] vertices) {
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].cost == Long.MAX_VALUE)
                System.out.print("-1 ");
            else
                System.out.print(vertices[i].cost + " ");
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int id;
        boolean visited = false;
        long cost = Long.MAX_VALUE;
        Vertex previous = null;
        List<Edge> adjacentVertices = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex vertex, int w) {
            adjacentVertices.add(new Edge(vertex, w));
        }

        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static class Edge {
        int weight;
        Vertex endpoint;

        public Edge(Vertex endpoint, int w) {
            this.endpoint = endpoint;
            this.weight = w;
        }
    }
}
