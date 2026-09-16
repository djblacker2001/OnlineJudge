import java.util.*;

public class CutVertex_EIREMOV {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int timer = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
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
            if (!ver[i].visited) {
                dfs(ver[i], null);
            }
        }

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (ver[x].isCut) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    static void dfs(Vertex u, Vertex parent) {
        u.visited = true;
        u.disc = u.low = ++timer;
        int child = 0;
        for (Vertex v : u.adjacent) {
            if (v == parent) {
                continue;
            }
            if (!v.visited) {
                child++;
                dfs(v, u);
                u.low = Math.min(u.low, v.low);
                if (parent != null && v.low >= u.disc) {
                    u.isCut = true;
                }
            } else {
                u.low = Math.min(u.low, v.disc);
            }
        }

        if (parent == null && child > 1)
            u.isCut = true;
    }

    static class Vertex {
        int id;
        boolean visited;
        List<Vertex> adjacent = new ArrayList<>();
        int disc;
        int low;
        boolean isCut;

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}
