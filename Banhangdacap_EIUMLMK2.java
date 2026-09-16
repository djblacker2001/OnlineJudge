import java.util.*;

public class Banhangdacap_EIUMLMK2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
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

        for (int i = 0; i < n; i++) {
            ver[i].product = sc.nextLong();
        }

        long price = sc.nextLong();
        dfs(ver[0], price);
        for (Vertex v : ver) {
            sb.append(v.count).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex u, long price) {
        u.visited = true;
        if (u.product >= price) {
            u.count = 1;
        } else {
            return;
        }
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                if (v.product < price * 110 / 100) {
                    u.count += Count(v);
                } else {
                    dfs(v, price * 110 / 100);
                }
            }
        }
    }

    static long Count(Vertex u) {
        u.visited = true;
        long count = 1;
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                count += Count(v);
            }
        }
        return count;
    }

    static class Vertex {
        int id;
        long count;
        boolean visited = false;
        long product;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}