import java.util.*;
import java.io.*;

public class Subarraywiththelargestsum_EISUBARRAY {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }

        int maxSum = a[0];
        int minSum = a[0];
        int currentMax = a[0];
        int currentMin = a[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(a[i], currentMax + a[i]);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(a[i], currentMin + a[i]);
            minSum = Math.min(minSum, currentMin);
        }

        int result = Math.max(Math.abs(maxSum), Math.abs(minSum));
        System.out.println(result);
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

		public char nextChar() {
			return next().charAt(0);
		}
	}
}
