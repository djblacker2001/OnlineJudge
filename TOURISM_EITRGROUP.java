import java.util.*;

public class TOURISM_EITRGROUP {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int maxLevel = 0;

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		Vertex adj[] = new Vertex[n];
		int degree[] = new int[n];

		for (int i = 0; i < n; i++)
			adj[i] = new Vertex(i);

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].addVertex(adj[v]);
			degree[v]++;
		}

		for (int i = 0; i < n; i++) {
			if (degree[i] == 0) {
				dfs(adj[i], 1);
			}
		}

		System.out.println(maxLevel);
	}

	static void dfs(Vertex u, int level) {
		maxLevel = Math.max(maxLevel, level);
		for (Vertex v : u.adjacent) {
			dfs(v, level + 1);
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
}
