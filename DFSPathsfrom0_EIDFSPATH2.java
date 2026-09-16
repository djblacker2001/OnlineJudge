import java.util.*;

public class DFSPathsfrom0_EIDFSPATH2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Vertex ver[] = new Vertex[n];
        Vertex parent[] = new Vertex[n];
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

        dfs(ver[0], parent);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (!ver[x].visited) {
                sb.append(-1).append("\n");
            } else {
                printPath(ver[x], parent);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static void dfs(Vertex u, Vertex parent[]) {
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                parent[v.id] = u;
                dfs(v, parent);
            }
        }
    }

    static void printPath(Vertex u, Vertex parent[]) {
        if (parent[u.id] != null) {
            printPath(parent[u.id],  parent);
        }
        sb.append(u.id).append(" ");
    }

    static class Vertex {
        int id;
        boolean visited;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}