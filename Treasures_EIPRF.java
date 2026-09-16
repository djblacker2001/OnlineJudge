import java.util.*;

public class Treasures_EIPRF {
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
            ver[u].addVertex(ver[v]);
        }

        for (Vertex v : ver) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
        }

        sb.append(0);
        for (Vertex v : ver[0].adjacent) {
            List<Integer> list = dfs(v, 0);
            if (list != null) {
                Collections.reverse(list);
                for (Integer a : list) {
                    sb.append(" ").append(a);
                }
            }
        }
        System.out.println(sb);
    }

    static List<Integer> dfs(Vertex u, int id) {
        if (u.id == id) {
            return new ArrayList<>();
        }
        for (Vertex v : u.adjacent) {
            List<Integer> list = (dfs(v, id));

            if (!v.visited) {
                v.visited = true;
                if (list != null) {
                    list.add(u.id);
                    return list;
                }
            }
        }
        return null;
    }

    static class Vertex {
        int id;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex vertex) {
            adjacent.add(vertex);
        }
    }
}
