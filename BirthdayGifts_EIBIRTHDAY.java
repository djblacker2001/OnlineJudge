import java.util.*;

public class BirthdayGifts_EIBIRTHDAY {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        Vertex ver[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            int date = sc.nextInt();
            ver[i] = new Vertex(i, date);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ver[u].addVertex(ver[v]);
            ver[v].addVertex(ver[u]);
        }

        for (Vertex v : ver) {
            v.adjacent.sort((s1, s2) -> s1.id - s2.id);
        }
        birthdayGifts(ver, d, k);
        System.out.println(sb);

    }

    static void birthdayGifts(Vertex[] adj, int d, int k) {
        int day = d + k;
        if (d + k > 365) {
            day = d + k - 365;
        }
        for (Vertex u : adj) {
            int count = 0;
            for (Vertex v : u.adjacent) {
                if (d + k > 365) {
                    if (v.birthday >= d && v.birthday <= 365 || v.birthday <= day) {
                        count++;
                    }
                } else {
                    if (v.birthday >= d && v.birthday <= day) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
    }

    static class Vertex {
        int id;
        int birthday;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(int id, int birthday) {
            this.id = id;
            this.birthday = birthday;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
        }
    }
}
