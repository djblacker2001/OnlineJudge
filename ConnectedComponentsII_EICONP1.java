import java.util.*;
import java.io.*;

public class ConnectedComponentsII_EICONP1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		Vertex adj[] = new Vertex[n];
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

		for (Vertex v : adj) {
			if (!v.visited) {
				v.visited = true;
				sb.append(v.id).append(" ").append(dfs(v)).append("\n");
			}
		}

		System.out.println(sb);

	}

	static int dfs(Vertex v) {
		int count = 1;
		for (Vertex ver : v.adjacent) {
			if (!ver.visited) {
				ver.visited = true;
				count += dfs(ver);
			}
		}
		return count;
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
