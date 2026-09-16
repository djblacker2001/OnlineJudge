import java.util.*;

public class MultiLevelMarketing_EIMULEMA {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < n; i++) {
            ver[i].commission = sc.nextLong() * 15 / 100;
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
        }

        dfs(ver[0]);
        for (Vertex v : ver) {
            sb.append(v.id).append(" ").append(v.commission).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex u) {
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                v.visited = true;
                dfs(v);
                u.commission += v.commission / 2;
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited = false;
        long commission = 0;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}