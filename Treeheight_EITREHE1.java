import java.util.*;

public class Treeheight_EITREHE1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int maxDist;

    public static void main(String[] args) {
        maxDist = Integer.MIN_VALUE;
        int n = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        dfs(ver[0],0);
        System.out.println(maxDist);

    }

    static void dfs(Vertex u, int depth) {
        u.visited = true;
        if (u.id != 1 && u.adjacent.size() == 1) {
            maxDist = Math.max(maxDist, depth);
        }

        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                dfs(v, depth + 1);
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