import java.util.*;

public class Caykphan_EIKARY {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
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

        dfs(ver[0]);
        if (kary(ver, k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean kary(Vertex adj[], int k) {
        for (Vertex v : adj) {
            int children = v.adjacent.size();
            if (v != adj[0]) {
                children--;
            }
            if (children > k) {
                return false;
            }
        }
        return true;
    }

    static void dfs(Vertex u) {
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                dfs(v);
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
