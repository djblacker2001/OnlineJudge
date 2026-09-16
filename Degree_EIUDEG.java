import java.util.*;

public class Degree_EIUDEG {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex ver[] = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        for(int i = 1; i <= n; i++) {
            sb.append(ver[i].degree).append(" ");
        }

        System.out.println(sb);
    }

    static class Vertex {
        int id;
        int degree;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
            this.degree++;
        }
    }
}
