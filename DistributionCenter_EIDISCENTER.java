import java.util.*;
import java.io.*;

public class DistributionCenter_EIDISCENTER {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    static long[] distSum;
    static int[] subtreeSize;
    static long[] ans;
    static int n;

    public static void main(String[] args) {
        n = reader.nextInt();
        Vertex[] adj = new Vertex[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            int w = reader.nextInt();
            adj[u].addVertex(new Edge(adj[v], w));
            adj[v].addVertex(new Edge(adj[u], w));
        }

        // prepare DP arrays
        distSum = new long[n];
        subtreeSize = new int[n];
        ans = new long[n];

        dfs1(adj[0], null);
        long totalRootDist = 0;
        for (int i = 0; i < n; i++) {
            totalRootDist += distSum[i];
        }

        ans[0] = totalRootDist;

        dfs2(adj[0], null);
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, ans[i]);
        }

        System.out.println(result);
    }

    static void dfs1(Vertex u, Vertex parent) {
        subtreeSize[u.id] = 1;

        for (Edge e : u.adjacent) {
            Vertex v = e.ver;
            if (v == parent)
                continue;

            distSum[v.id] = distSum[u.id] + e.length;
            dfs1(v, u);

            subtreeSize[u.id] += subtreeSize[v.id];
        }
    }

    static void dfs2(Vertex u, Vertex parent) {
        for (Edge e : u.adjacent) {
            Vertex v = e.ver;
            if (v == parent)
                continue;

            ans[v.id] = ans[u.id] + e.length * (n - 2L * subtreeSize[v.id]);

            dfs2(v, u);
        }
    }

    static class Edge {
        Vertex ver;
        int length;

        public Edge(Vertex ver, int length) {
            this.ver = ver;
            this.length = length;
        }
    }

    static class Vertex {
        int id;
        List<Edge> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Edge e) {
            adjacent.add(e);
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String temp;

        public InputReader(InputStream stream) {
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
