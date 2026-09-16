import java.util.*;

public class Bipartitegraph_EIBIPARTITE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Vertex ver[] = new Vertex[n];
            for (int i = 0; i < n; i++) {
                ver[i] = new Vertex(i);
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                ver[u].addVertex(ver[v]);
                ver[v].addVertex(ver[u]);
            }

            boolean isBi = true;
            for (Vertex v : ver) {
                if (v.group == 0) {
                    v.group = 1;
                    isBi = isBipartite(v);
                    if (!isBi) {
                        break;
                    }
                }
            }

            if (isBi) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isBipartite(Vertex u) {
        for (Vertex v : u.adjacent) {
            if (v.group == 0) {
                v.group = 3 - u.group;
                if (!isBipartite(v)) {
                    return false;
                }
            } else if (v.group == u.group) {
                return false;
            }
        }
        return true;
    }

    static class Vertex {
        int id;
        int group = 0;
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