import java.util.*;

public class ConnectedComponents3_EICONP3 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
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

        for (Vertex v : ver)
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);

        for (Vertex v : ver) {
            if (!v.visited1) {
                sb.append(v.id).append(" ").append(dfsVertex(v)).append(" ").append(dfsEdge(v)/2).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int dfsVertex (Vertex u) {
        u.visited1 = true;
        int count = 1;
        for (Vertex v : u.adjacent) {
            if (!v.visited1) {
                count += dfsVertex(v);
            }
        }
        return count;
    }

    static int dfsEdge (Vertex u) {
        u.visited2 = true;
        int degree = u.adjacent.size();
        for (Vertex v : u.adjacent) {
            if (!v.visited2) {
                degree += dfsEdge(v);
            }
        }
        return degree;
    }

    static class Vertex {
        int id;
        boolean visited1;
        boolean visited2;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}
