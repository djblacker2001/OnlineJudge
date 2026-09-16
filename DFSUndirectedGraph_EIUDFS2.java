import java.util.*;

public class DFSUndirectedGraph_EIUDFS2 {
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

		dfs(ver[0]);
        System.out.println(sb);
    }

    static void dfs(Vertex u) {
		u.visited = true;
		sb.append(u.id).append(" ");
		for (Vertex v : u.adjacent) {
			if (!v.visited) {
				v.visited=true;
				dfs(v);
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