import java.util.*;
import java.io.*;

public class Christmasdiscount_EIUCHRMS {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		double[] rate = { 0.97, 0.96, 0.95, 0.94, 0.93, 0.92, 0.91, 0.1 };
		long[] lv = { 0, 2_000_000, 5_000_000, 10_000_000, 20_000_000, 50_000_000, 100_000_000, 200_000_000,
				Long.MAX_VALUE };
		long sum = 0;
		for (int i = 0; i < n; i++) {
			long a = reader.nextLong();
			for (int j = 0; j < rate.length; j++) {
				if (lv[j] < a && a <= lv[j + 1])
					sum += a * rate[j];
			}
		}
		System.out.println(sum);
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
