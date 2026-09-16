import java.util.*;
import java.io.*;

public class CompleteBipartite_EIFBIPARTIE {
    // Lớp đại diện cho một cạnh để dễ dàng sắp xếp
    static class Edge implements Comparable<Edge> {
        long u, v;

        Edge(long a, long b) {
            // Luôn để số nhỏ đứng trước để đảm bảo tính nhất quán
            if (a < b) {
                this.u = a;
                this.v = b;
            } else {
                this.u = b;
                this.v = a;
            }
        }

        @Override
        public int compareTo(Edge other) {
            if (this.u != other.u) {
                return Long.compare(this.u, other.u);
            }
            return Long.compare(this.v, other.v);
        }

        @Override
        public String toString() {
            return u + " " + v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] setA = new long[n];
        long[] setB = new long[m];

        // Đọc tập đỉnh thứ nhất
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            setA[i] = Long.parseLong(st.nextToken());
        }

        // Đọc tập đỉnh thứ hai
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            setB[j] = Long.parseLong(st.nextToken());
        }

        // Tạo danh sách cạnh
        List<Edge> edges = new ArrayList<>(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                edges.add(new Edge(setA[i], setB[j]));
            }
        }

        // Sắp xếp danh sách cạnh theo thứ tự từ điển
        Collections.sort(edges);

        // Sử dụng StringBuilder để in kết quả nhanh hơn
        StringBuilder sb = new StringBuilder();
        for (Edge e : edges) {
            sb.append(e.u).append(" ").append(e.v).append("\n");
        }
        System.out.print(sb.toString());
    }
}