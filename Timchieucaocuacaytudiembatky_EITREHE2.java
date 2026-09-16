import java.util.*;
import java.io.*;

public class Timchieucaocuacaytudiembatky_EITREHE2 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static int length;

    public static void main(String[] args) {
        int n = reader.nextInt();
        Vertex adj[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj[u].addVertex(adj[v]);
            adj[v].addVertex(adj[u]);
        }

        for (Vertex v : adj) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
        }

        int q = reader.nextInt();
        for (int i = 0; i < q; i++) {
            int vertex = reader.nextInt();
            length = 0;
            dfs(adj[vertex], 0);
            sb.append(length).append("\n");
            reset(adj);
        }

        System.out.println(sb);
    }

    static void dfs(Vertex u, int level) {
        u.visited = true;
        if (level > length) {
            length = level;
        }
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                v.visited = true;
                dfs(v, level + 1);
            }
        }
    }

    static void reset(Vertex adj[]) {
        for (int i = 0; i < adj.length; i++) {
            adj[i].visited = false;
        }
    }

    static class Vertex {
        int id;
        boolean visited = false;
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