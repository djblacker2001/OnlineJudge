import java.util.*;
import java.io.*;

public class Orderofthesequence_EIINCRDES {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] array = new int[n];
        boolean desFlag = true;
        boolean insFlag = true;
        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }
        if (array[0] == array[1]) {
            System.out.println("none");
            return;
        }
        if (array[1] > array[0]) {
            for (int i = 1; i < n; i++) {
                if (array[i] <= array[i-1]) {
                    System.out.println("none");
                    return;
                }
            }
            System.out.println("increasing");
        }
        else {
            for (int i = 1; i < n; i++) {
                if (array[i] >= array[i-1]) {
                    System.out.println("none");
                    return;
                }
            }
            System.out.println("decreasing");
            
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