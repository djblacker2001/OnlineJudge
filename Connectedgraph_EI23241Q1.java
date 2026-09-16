import java.util.*;

public class Connectedgraph_EI23241Q1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Vertex ver[] = new Vertex[n + 1];
            for (int i = 1; i <= n; i++) {
                ver[i] = new Vertex(i);
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                ver[u].addVertex(ver[v]);
                ver[v].addVertex(ver[u]);
            }

            for (int i = 1; i <= n; i++) {
                ver[i].adjacent.sort((s1, s2) -> s1.id - s2.id);
            }

            if (Component(ver) == 1) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static int Component(Vertex ver[]) {
		int count = 0;
		for (int i = 1;i<ver.length;i++) {
			if (!ver[i].visited) {
				ver[i].visited = true;
				dfs(ver[i]);
				count++;
			}
		}
		return count;
	}

    static void dfs(Vertex u) {
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
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

        public void addVertex(Vertex vertex) {
            adjacent.add(vertex);
        }
    }
}
