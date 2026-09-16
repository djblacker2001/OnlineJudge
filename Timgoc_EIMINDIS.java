import java.util.*;
import java.io.*;

public class Timgoc_EIMINDIS {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Vertex[] adj;
    static boolean[] isLeaf;
    static int[] subLeaf;
    static long[] distSum;
    static int totalLeaf;

    public static void main(String[] args) {
        n = reader.nextInt();
        adj = new Vertex[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj[u].addVertex(adj[v]);
            adj[v].addVertex(adj[u]);
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        isLeaf = new boolean[n];
        subLeaf = new int[n];
        distSum = new long[n];

        for (int i = 0; i < n; i++) {
            if (adj[i].adjacent.size() == 1) {
                isLeaf[i] = true;
                totalLeaf++;
            }
        }

        dfs1(adj[0], null, 0);
        dfs2(adj[0], null);

        long best = Long.MAX_VALUE;
        int bestNode = 0;
        for (int i = 0; i < n; i++) {
            if (distSum[i] < best) {
                best = distSum[i];
                bestNode = i;
            }
        }

        System.out.println(bestNode);
    }

    static void dfs1(Vertex u, Vertex parent, int depth) {
        if (isLeaf[u.id]) {
            subLeaf[u.id] = 1;
            distSum[0] += depth;
        }

        for (Vertex v : u.adjacent) {
            if (v == parent) continue;
            dfs1(v, u, depth + 1);
            subLeaf[u.id] += subLeaf[v.id];
        }
    }

    static void dfs2(Vertex u, Vertex parent) {
        for (Vertex v : u.adjacent) {
            if (v == parent) continue;

            distSum[v.id] = distSum[u.id]
                    + (totalLeaf - subLeaf[v.id])
                    - subLeaf[v.id];

            dfs2(v, u);
        }
    }

    static class Vertex {
        int id;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
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

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {}
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
