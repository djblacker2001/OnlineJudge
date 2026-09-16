import java.util.*;
import java.io.*;

public class LocalAreaNetwork_EILOCAL2 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        Vertex adj[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            int w = reader.nextInt();
            adj[u].adjacent.add(new Edge(adj[v], w));
            adj[v].adjacent.add(new Edge(adj[u], w));
        }

        dfs(adj[0]);
        int maxDistance = 0;
        for (Vertex v : adj) {
            maxDistance = Math.max(maxDistance, v.distance);
        }
        System.out.println(maxDistance);
    }

    static void dfs(Vertex u) {
        u.visited = true;
        for (Edge v : u.adjacent) {
            if (!v.vertex.visited) {
                v.vertex.distance = u.distance + v.length;
                dfs(v.vertex);
            }
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
        int distance;
        boolean visited = false;
        List<Edge> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Edge v) {
            adjacent.add(v);
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}