import java.util.*;

public class Isthereapathafterremovingavertex_EIHCON1 {
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
            ver[v].addVertex(ver[u]);
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = sc.nextInt();
            if (isPath(ver[a], ver[b], r)) {
                sb.append("Y").append("\n");
            } else {
                sb.append("N").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isPath(Vertex a, Vertex b, int r) {
        if (a.id == r || b.id == r) {
            return false;
        }
        if (a.adjacent.contains(b)) {
            return true;
        }
        for (Vertex v : a.adjacent) {
            if (v.id == r)
                continue;
            if (v.adjacent.contains(b)) {
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
