import java.util.*;

public class Istree_EICHTTRE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
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

            dfs(ver[0]);
            if (Component(ver) == 1 && m == n - 1) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);

    }

    static int Component(Vertex ver[]) {
        reset(ver);
        int count = 0;
        for (Vertex v : ver) {
            if (!v.visited) {
                v.visited = true;
                dfs(v);
                count++;
            }
        }
        return count;
    }

    static void dfs(Vertex v) {
        v.visited = true;
        for (Vertex ver : v.adjacent) {
            if (!ver.visited) {
                dfs(ver);
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
