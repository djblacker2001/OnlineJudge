import java.util.*;

public class Isbridge2_EIBRIDGE2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static HashSet<Long> bridges = new HashSet<>();
    static int time = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        Vertex[] ver = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        for (int i = 0; i < n; i++) {
            if (ver[i].num == 0) {
                tarjan(ver[i], null);
            }
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long key = getKey(a, b);
            if (bridges.contains(key)) {
                sb.append("Y").append("\n");
            } else {
                sb.append("N").append("\n");
            }

        }

        System.out.print(sb);
    }

    static void tarjan(Vertex u, Vertex parent) {
        u.num = u.low = ++time;
        for (Vertex v : u.adjacent) {
            if (v == parent) {
                continue;
            }

            if (v.num == 0) {
                tarjan(v, u);
                u.low = Math.min(u.low, v.low);
                if (v.low > u.num) {
                    bridges.add(getKey(u.id, v.id));
                }
            } else {
                u.low = Math.min(u.low, v.num);
            }
        }
    }

    static long getKey(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        return (((long) a) << 32) | (b & 0xffffffffL);
    }

    static class Vertex {
        int id;
        int num;
        int low;
        boolean visited = false;
        ArrayList<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}