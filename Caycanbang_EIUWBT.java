import java.util.*;

public class Caycanbang_EIUWBT {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex ver[] = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 1; i <= n; i++) {
            ver[i].weight = sc.nextLong();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        dfs(ver[1], null);
        long totalWeight = ver[1].weight;
        long bestW1 = 0;
        long bestW2 = 0;
        long bestVer = 0;
        long bestDif = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (ver[i].adjacent.size() == 2) {
                long w1 = 0;
                if (ver[i].adjacent.get(0) != ver[i].parent) {
                    w1 = ver[i].adjacent.get(0).weight;
                } else {
                    w1 = totalWeight - ver[i].weight;
                }
                long w2 = 0;
                if (ver[i].adjacent.get(1) != ver[i].parent) {
                    w2 = ver[i].adjacent.get(1).weight;
                } else {
                    w2 = totalWeight - ver[i].weight;
                }

                long dif = Math.abs(w1 - w2);
                if (dif < bestDif || (dif == bestDif && i < bestVer)) {
                    bestDif = dif;
                    bestVer = i;
                    bestW1 = Math.min(w1, w2);
                    bestW2 = Math.max(w1, w2);
                }
            }
        }
        if (bestVer == -1 || bestW1 == bestW2) {
            System.out.println("-1");
        } else {
            System.out.println(bestVer + " " + bestW1 + " " + bestW2);
        }
    }

    static void dfs(Vertex u, Vertex p) {
        u.parent = p;
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (v == p) {
                continue;
            }
            if (!v.visited) {
                dfs(v, u);
                u.weight += v.weight;
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();
        Vertex parent;
        long weight;

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}
