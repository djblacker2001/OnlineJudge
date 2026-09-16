import java.io.*;
import java.util.*;

public class Question3_EISCOPN {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);
    static int compId = 0;  
    static int[] component;    

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int q = reader.nextInt();

        Vertex[] adj = new Vertex[n];
        component = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new Vertex(i);
        }


        for (int i = 0; i < m; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            adj[u].addVertex(adj[v]);
            adj[v].addVertex(adj[u]);
        }


        for (Vertex v : adj) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
        }

        for (int i = 0; i < n; i++) {
            if (!adj[i].visited) {
                dfs(adj[i]);
                compId++;
            }
        }

        for (int i = 0; i < q; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            if (component[a] == component[b]) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(Vertex v) {
        v.visited = true;
        component[v.id] = compId;

        for (Vertex ver : v.adjacent) {
            if (!ver.visited) {
                dfs(ver);
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex vertex) {
            adjacent.add(vertex);
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
