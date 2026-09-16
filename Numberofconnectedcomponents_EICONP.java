import java.util.*;

public class Numberofconnectedcomponents_EICONP {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		Vertex ver[] = new Vertex[n];
		for (int i = 0; i < n; i++) {
			ver[i] = new Vertex(i);
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			ver[u].addVertex(ver[v]);
			ver[v].addVertex(ver[u]);
		}

		System.out.println(Component(ver));
	}

	static int Component(Vertex ver[]) {
		int count = 0;
		for (Vertex v : ver) {
			if (!v.visited) {
				v.visited = true;
				bfs(v);
				count++;
			}
		}
		return count;
	}

	static void bfs(Vertex u) {
		Queue<Vertex> q = new ArrayDeque<>();
		q.add(u);
		u.visited = true;
		while (!q.isEmpty()) {
			Vertex adj = q.poll();
			for (Vertex v : adj.adjacent) {
				if (!v.visited) {
					v.visited = true;
					q.add(v);
				}
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

		public void addVertex(Vertex v) {
			adjacent.add(v);
		}
	}
}
