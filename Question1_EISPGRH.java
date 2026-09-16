import java.util.*;
import java.io.*;

public class Question1_EISPGRH {
    static InputReader reader = new InputReader(System.in);

    // Edge dùng để sort và kiểm tra trùng
    static class Edge implements Comparable<Edge> {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
        public int compareTo(Edge o) {
            if (u != o.u) return u - o.u;
            return v - o.v;
        }
    }

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();

        // Lưu cạnh để sort
        Edge[] edges = new Edge[m];


        Vertex[] adj = new Vertex[n];
        for (int i = 0; i < n; i++) adj[i] = new Vertex(i);

        for (int i = 0; i < m; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();

            // ❌ self-loop → NO
            if (u == v) {
                System.out.println("NO");
                return;
            }

            // Lưu vào adjacency list (giữ lại theo code bạn)
            adj[u].addVertex(adj[v]);
            adj[v].addVertex(adj[u]);

            // Chuẩn hóa cạnh
            int a = Math.min(u, v);
            int b = Math.max(u, v);

            edges[i] = new Edge(a, b);
        }

        // Sắp xếp cạnh
        Arrays.sort(edges);

        // ❌ kiểm tra cạnh trùng
        for (int i = 1; i < m; i++) {
            if (edges[i].u == edges[i - 1].u &&
                edges[i].v == edges[i - 1].v) {
                System.out.println("NO");
                return;
            }
        }

        // Nếu không vi phạm gì
        System.out.println("YES");
    }

    // Các class gốc của bạn giữ nguyên
    static class Vertex {
        public int id;
        public boolean visited = false;
        public List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) { this.id = id; }
        public void addVertex(Vertex v) { adjacent.add(v); }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String temp;

        public InputReader(InputStream stream) {
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
