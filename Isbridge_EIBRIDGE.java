import java.util.*;

public class Isbridge_EIBRIDGE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
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

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ver[a].removeVertex(ver[b]);
            ver[b].removeVertex(ver[a]);
            reset(ver);
            if (dfs(ver[a], b)) {
                sb.append("N").append("\n");
            } else {
                sb.append("Y").append("\n");
            }
            ver[a].addVertex(ver[b]);
            ver[b].addVertex(ver[a]);
        }

        System.out.println(sb);
    }

    static boolean dfs(Vertex u, int end) {
        if (u.id == end) {
            return true;
        }
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.visited)
                if (dfs(v, end)) {
                    return true;
                }
        }

        return false;
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

        public void removeVertex(Vertex v) {
            adjacent.remove(v);
        }
    }
}
