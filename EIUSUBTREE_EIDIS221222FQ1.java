import java.util.*;
import java.io.*;

public class EIUSUBTREE_EIDIS221222FQ1 {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    static int[] subtree;
    static long maxSum = 0;

    public static void main(String[] args) {
        int n = reader.nextInt();
        Vertex[] adj = new Vertex[n];
        subtree = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }

        for(int i = 0; i < n; i++) {
            subtree[i] = reader.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj[u].addVertex(adj[v]);
            adj[v].addVertex(adj[u]);
        }
        dfs(adj[0]);
        sb.append(maxSum);
        System.out.println(sb);

    }

    static long dfs(Vertex v) {
        v.visited = true;
        long sum = subtree[v.id];
        for (Vertex ver : v.adjacent) {
            if (!ver.visited) {
                sum += dfs(ver);
            }
        }
        maxSum = Math.max(maxSum, sum);
        return sum;
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

		char nextChar() {
			return next().charAt(0);
		}
	}
}