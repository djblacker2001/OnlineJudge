import java.util.*;

public class Isthereapathafterremovinganedge_EIHCON2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        Vertex ver[] = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (isPath(ver[a], ver[b], x, y)) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isPath(Vertex a, Vertex b, int x, int y) {
        if (a.adjacent.contains(b)) {
            if (!(a.id == x && b.id == y)) {
                return true;
            }

        }
        for (Vertex v : a.adjacent) {
            if (a.id == x && v.id == y) {
                continue;
            }

            if (v.adjacent.contains(b)) {
                if (v.id == x && b.id == y) {
                    continue;
                }

                return true;
            }
        }

        return false;
    }

    static class Vertex {
        int id;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }

}
