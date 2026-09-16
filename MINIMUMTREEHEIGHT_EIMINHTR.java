import java.util.*;
import java.io.*;

public class MINIMUMTREEHEIGHT_EIMINHTR {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        Vertex[] adj = new Vertex[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj[u].addVertex(adj[v]);
            adj[v].addVertex(adj[u]);
        }

        Queue<Vertex> queue = new ArrayDeque<>();
        int remaining = n;

        for (int i = 0; i < n; i++) {
            if (adj[i].adjacent.size() == 1) {
                queue.add(adj[i]);
            }
        }

        int height = 0;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            height++;

            for (int i = 0; i < size; i++) {
                Vertex leaf = queue.poll();

                for (Vertex nei : leaf.adjacent) {
                    nei.adjacent.remove(leaf);
                    if (nei.adjacent.size() == 1) {
                        queue.add(nei);
                    }
                }
                leaf.adjacent.clear();
            }
        }

        int root = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            root = Math.min(root, queue.poll().id);
        }

        if (remaining == 2) height++;
        System.out.println(root + " " + height);

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