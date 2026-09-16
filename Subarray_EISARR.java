import java.util.*;
import java.io.*;

public class Subarray_EISARR {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = reader.nextInt();
		}
		long max = 0, sum = 0;

		for (int i = 0; i < k; i++)
			sum = sum + a[i];

		max = sum;
		for (int i = k; i < n; i++) {
			sum += a[i] - a[i - k];
			if (sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
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
