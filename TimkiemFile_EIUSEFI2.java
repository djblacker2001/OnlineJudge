import java.util.*;

public class TimkiemFile_EIUSEFI2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Hashtable<String, Vertex> ver = new Hashtable<>();
        int n = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            String u = sc.next();
            String v = sc.next();
            ver.putIfAbsent(u, new Vertex(u));
            ver.putIfAbsent(v, new Vertex(v));
            ver.get(u).addVertex(ver.get(v));
            ver.get(v).addVertex(ver.get(u));
        }

        for (Vertex v : ver.values()) {
            v.adjacent.sort((s1, s2) -> s1.id.compareTo(s2.id));
        }

        String file = sc.next();
        String key = sc.next();
        Vertex root = ver.get(file);
        dfs(root, root, key);
        System.out.println(sb);
    }

    static int dfs(Vertex root, Vertex u, String key) {
        int count = 0;
        u.visited = true;
        for (Vertex v : u.adjacent) {
            if (!v.id.equals(root.id)) {
                count += dfs(u, v, key);
            }
        }
        if (count > 0) {
            sb.append(u.id).append(" ").append(count).append("\n");
        }
        if (u.adjacent.size() == 1 && u.id.contains(key)) {
            count = 1;
        }
        return count;
    }

    static class Vertex {
        String id;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(String id) {
            this.id = id;
        }

        public void addVertex(Vertex vertex) {
            adjacent.add(vertex);
        }
    }
}
