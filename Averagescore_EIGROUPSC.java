import java.util.*;

public class Averagescore_EIGROUPSC {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static double maxScore = Integer.MIN_VALUE;
    static double minScore = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] ver = new Vertex[n];

        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
            ver[i].score = sc.nextDouble();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        for (int i = 0; i < n; i++) {
            if (!ver[i].visited) {
                maxScore = ver[i].score;
                minScore = ver[i].score;
                dfs(ver[i]);
                sb.append(maxScore).append(" ").append(minScore).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void dfs(Vertex u) {
        u.visited = true;
        maxScore = Math.max(maxScore, u.score);
        minScore = Math.min(minScore, u.score);
        for (Vertex v : u.adjacent) {
            if (!v.visited)
                dfs(v);
        }
    }

    static class Vertex {
        int id;
        boolean visited;
        double score;
        ArrayList<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}