import java.util.*;

public class Overflow_WTRABS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < n; i++) {
            ver[i].water = sc.nextDouble();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[v].addVertex(ver[u]);
        }

        dfs(ver[0]);
        for (Vertex v : ver) {
            if (v.adjacent.size() == 0) {
                sb.append(v.id).append(" ").append(v.water).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(Vertex u) {
        u.visited = true;
        double watering = 0;
        if (u.adjacent.size() > 0) {
            watering = u.water / u.adjacent.size();
        }
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                v.water += watering;
                dfs(v);
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited = false;
        double water;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}
