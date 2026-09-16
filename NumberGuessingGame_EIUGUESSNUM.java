import java.util.*;
import java.io.*;

public class NumberGuessingGame_EIUGUESSNUM {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        long a = reader.nextLong();
        long b = reader.nextLong();

        while (a <= b) {
            long mid = a + (b - a) / 2;
            System.out.println(mid);
            System.out.flush();
            String response = reader.next();

            if (response.equals("WIN")) {
                return;
            } else if (response.equals("LOW")) {
                a = mid + 1;
            } else if (response.equals("HIGH")) {
                b = mid - 1;
            }
        }
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
