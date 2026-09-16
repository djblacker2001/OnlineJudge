import java.util.*;

public class FacebookFriends_EIFBF {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex ver[] = new Vertex[n + 1];
        List<Gender> sex = new ArrayList<>();

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

        for (int i = 1; i < ver.length; i++) {
            if (!ver[i].visited) {
                Gender component = new Gender(i);
                if (ver[i].isMale)
                    component.male++;
                else
                    component.female++;

                ver[i].visited = true;
                dfs(ver[i], component);
                sex.add(component);
            }
        }

        sex.sort((s1, s2) -> s1.id - s2.id);

        for (Gender g : sex) {
            sb.append(g.id).append(" ").append(g.male).append(" ").append(g.female).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(Vertex u, Gender component) {
        for (Vertex v : u.adjacent) {
            if (!v.visited) {
                if (v.id > component.id) {
                    component.id = v.id;
                }
                if (v.isMale)
                    component.male++;
                else
                    component.female++;

                v.visited = true;
                dfs(v, component);
            }
        }
    }

    static class Vertex {
        int id;
        boolean isMale = false;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex vertex) {
            adjacent.add(vertex);
        }
    }

    static class Gender {
        int id;
        int male;
        int female;

        public Gender(int id) {
            this.id = id;
        }
    }
}
