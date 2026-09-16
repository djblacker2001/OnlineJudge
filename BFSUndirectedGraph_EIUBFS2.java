import java.util.*;

public class BFSUndirectedGraph_EIUBFS2 {
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

		for (Vertex v : ver) {
			v.adjacent.sort((s1, s2) -> s1.id - s2.id);
		}

        bfs(ver[0]);
        System.out.println(sb);
    }

    static void bfs(Vertex u) {
        Queue<Vertex> q = new ArrayDeque<>();
        q.add(u);
        u.visited = true;
        while (!q.isEmpty()) {
            Vertex adj = q.poll();
            sb.append(adj.id).append(" ");
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
		List<Vertex> adjacent = new ArrayList<Vertex>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}