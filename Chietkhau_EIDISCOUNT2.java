import java.util.*;
import java.io.*;

public class Chietkhau_EIDISCOUNT2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long n = reader.nextLong();
		long discount = 0;
		long[] levels = { 0, 5000000, 20000000, 100000000, 300000000, 600000000, 900000000, Long.MAX_VALUE };
		double[] rates = { 0, 0.03, 0.05, 0.07, 0.1, 0.12, 0.15 };
		for (int i = 0; i < rates.length; i++) {
			if (n >= levels[i])
				discount += (Math.min(n, levels[i + 1]) - levels[i]) * rates[i];
		}
		System.out.print(n - discount);
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
