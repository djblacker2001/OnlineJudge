import java.util.*;

public class Findacircuit_EIUCIRCUIT {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] parent;
    static int start = -1;
    static int end = -1;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex ver[] = new Vertex[n + 1];
        for (int i = 1; i <= n; i++)
            ver[i] = new Vertex(i);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!ver[i].visited) {
                if (dfs(ver[i], -1)) {
                    break;
                }
            }
        }

        if (start == -1) {
            System.out.println(-1);
            return;
        }
        
        List<Integer> cycle = new ArrayList<>();
        cycle.add(start);
        for (int v = end; v != start; v = parent[v]) {
            cycle.add(v);
        }
        Collections.reverse(cycle);
        for (int x : cycle) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    static boolean dfs(Vertex u, int p) {
        u.visited = true;
        parent[u.id] = p;
        for (Vertex v : u.adjacent) {
            if (v.id == p) {
                continue;
            }
            if (!v.visited) {
                if (dfs(v, u.id)) {
                    return true;
                }
            } else {
                start = v.id;
                end = u.id;
                return true;
            }
        }
        return false;
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
