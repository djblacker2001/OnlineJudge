import java.util.*;
import java.io.*;

public class NextGreaterElement_EIMONOSTACK1 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int m = reader.nextInt();
        int n = reader.nextInt();

        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = reader.nextInt();
        }

        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = reader.nextInt();
        }

        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : B) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        for (int i = 0; i < m; i++) {
            sb.append(nextGreater.get(A[i]));
            if (i < m - 1) sb.append(" ");
        }

        System.out.println(sb);
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
