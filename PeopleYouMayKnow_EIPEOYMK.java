import java.util.*;

public class PeopleYouMayKnow_EIPEOYMK {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
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

        int u = sc.nextInt();
        int q = sc.nextInt();
        bfs(ver[u]);

        for (Vertex v : ver) {
            if (!map.containsKey(v.level)) {
                map.put(v.level, new ArrayList<>());
            }
            map.get(v.level).add(v.id);
        }

        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            List<Integer> list = map.get(k); 
            if (list == null) {
                sb.append("-1").append("\n");
            } else {
                Collections.sort(list);
                for (Integer x : list) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void bfs(Vertex u) {
        Queue<Vertex> q = new ArrayDeque<>();
        u.visited = true;
        q.add(u);
        while (!q.isEmpty()) {
            Vertex adj = q.poll();
            for (Vertex v : adj.adjacent) {
                if (!v.visited) {
                    v.visited = true;
                    v.level = adj.level + 1;
                    q.add(v);
                }
            }
        }
    }

    static void dfs(Vertex u) {
		u.visited = true;
		for (Vertex v : u.adjacent) {
			if (!v.visited) {
				v.visited = true;
                v.level = u.level + 1;
				dfs(v);
			}
		}
	}

    static class Vertex {
        int id;
        int level;
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
