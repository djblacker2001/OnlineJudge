import java.util.*;

public class Makefriend_EIMKF {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (!ver[u].adjacent.contains(ver[v])) {
                ver[u].addVertex(ver[v]);
                ver[v].addVertex(ver[u]);
            }
        }

        for (Vertex v : ver) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
            sb.append(v.id).append(" ").append(v.adjacent.size()).append(" ");
            for (int i = 0; i < v.adjacent.size(); i++) {
                sb.append(v.adjacent.get(i).id).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

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
