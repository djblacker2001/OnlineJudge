import java.util.*;

public class FacebookFriends_EIFBF2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static List<Vertex> componentVertices;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] ver = new Vertex[n + 1];
        int[] maleCount = new int[n + 1];
        int[] femaleCount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 1; i <= n; i++) {
            String gender = sc.next();
            if (gender.equals("Nam")) {
                ver[i].isMale = true;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        for (int i = 1; i <= n; i++) {
            if (!ver[i].visited) {
                Gender component = new Gender(i);
                componentVertices = new ArrayList<>();
                if (ver[i].isMale) {
                    component.male++;
                } else {
                    component.female++;
                }

                ver[i].visited = true;
                componentVertices.add(ver[i]);

                dfs(ver[i], component);

                for (Vertex v : componentVertices) {
                    maleCount[v.id] = component.male;
                    femaleCount[v.id] = component.female;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(ver[i].id).append(" ").append(maleCount[i]).append(" ").append(femaleCount[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(Vertex u, Gender component) {
        for (Vertex v : u.adjacent) {
            if (!v.visited) {

                if (v.id > component.id)
                    component.id = v.id;

                if (v.isMale)
                    component.male++;
                else
                    component.female++;

                v.visited = true;
                componentVertices.add(v);

                dfs(v, component);
            }
        }
    }

    static class Vertex {
        int id;
        boolean isMale;
        boolean visited;
        List<Vertex> adjacent = new ArrayList<>();

        Vertex(int id) {
            this.id = id;
        }

        void addVertex(Vertex vertex) {
            adjacent.add(vertex);
        }
    }

    static class Gender {
        int id;
        int male;
        int female;

        Gender(int id) {
            this.id = id;
        }
    }
}