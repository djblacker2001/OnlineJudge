import java.util.*;
import java.io.*;

public class AverageValue_EIUAVERAGE {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextLong();
        }
        Arrays.sort(a);
        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + a[i];
        }
        
        int q = reader.nextInt();
        while (q-- > 0) {
            long k = reader.nextLong();
            
            int low = 1, high = n;
            int maxElements = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] < (long) mid * k) {
                    maxElements = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(maxElements);
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
