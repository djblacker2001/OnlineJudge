import java.util.*;
import java.io.*;

public class Question2_EISMLEDG {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        Vertex adj[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        HashMap<Long, Integer> map = new HashMap<>(m * 2);

        for (int i = 0; i < m; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            int w = reader.nextInt();

            int a = Math.min(u, v);
            int b = Math.max(u, v);

            long key = 1L * a * n + b;

            if (!map.containsKey(key))
                map.put(key, w);
            else
                map.put(key, Math.min(map.get(key), w));

            adj[u].addVertex(new Edge(adj[v], w));
            adj[v].addVertex(new Edge(adj[u], w));
        }

        List<int[]> edges = new ArrayList<>();
        for (long key : map.keySet()) {
            int u = (int) (key / n);
            int v = (int) (key % n);
            edges.add(new int[] { u, v, map.get(key) });
        }

        edges.sort((x, y) -> {
            if (x[0] != y[0])
                return x[0] - y[0];
            if (x[1] != y[1])
                return x[1] - y[1];
            return x[2] - y[2];
        });

        for (int[] e : edges) {
            sb.append(e[0]).append(" ").append(e[1]).append(" ").append(e[2]).append("\n");
        }

        System.out.print(sb.toString());
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
