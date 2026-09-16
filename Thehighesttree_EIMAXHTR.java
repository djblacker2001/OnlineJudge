import java.util.*;

public class Thehighesttree_EIMAXHTR {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int maxLevel = Integer.MIN_VALUE;
	static int farestId = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int n = sc.nextInt();
		Vertex ver[] = new Vertex[n];
		for (int i = 0; i < n; i++) {
			ver[i] = new Vertex(i);
		}

		for (int i = 0; i < n - 1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			ver[u].addVertex(ver[v]);
			ver[v].addVertex(ver[u]);
		}

		dfs(ver[0], 0);
		int far = farestId;
		reset(ver);
		dfs(ver[far], 0);
		sb.append(Math.min(far, farestId)).append(" ").append(maxLevel);
		System.out.println(sb);
	}

	static void dfs(Vertex v, int level) {
		v.visited = true;
		if (level > maxLevel || level == maxLevel && v.id < farestId) {
			maxLevel = level;
			farestId = v.id;
		}

		for (Vertex ver : v.adjacent) {
			if (!ver.visited) {
				dfs(ver, level + 1);
			}
		}
	}

	static void reset(Vertex ver[]) {
		for (int i = 0; i < ver.length; i++) {
			ver[i].visited = false;
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
}
