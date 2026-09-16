import java.util.*;
import java.io.*;

public class PreOrder_EIPREORDER2 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            left[i] = reader.nextInt();
            right[i] = reader.nextInt();
        }
        dfs(1, left, right);

        System.out.println(sb.toString());
    }

    static void dfs(int u, int[] left, int[] right) {
        sb.append(u).append(" ");
        if (left[u] > 0)
            dfs(left[u], left, right);
        if (right[u] > 0)
            dfs(right[u], left, right);
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public boolean hasNext() throws IOException {
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                return true;
            }
            temp = reader.readLine();
            return (temp != null && temp.length() > 0);
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }

                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
