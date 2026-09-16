import java.util.*;

public class PlantStatistics_EIGREENCITY {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
        }

        int leafcount = 0;
        for (Vertex v : ver) {
            if (v.adjacent.size() == 0) {
                leafcount++;
            }
        }
        for (int i = 0; i < leafcount; i++) {
            int leaf = sc.nextInt();
            int tree = sc.nextInt();
            ver[leaf].trees = tree;
        }

        dfs(ver[m]);
        for (Vertex v : ver) {
            sb.append(v.id).append(" ").append(v.trees).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex u) {
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                dfs(v);
                u.trees += v.trees;
            }
        }
    }

    static class Vertex {
        int id;
        int trees;
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
