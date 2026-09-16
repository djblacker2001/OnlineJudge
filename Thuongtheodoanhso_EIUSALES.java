import java.util.*;
import java.io.*;

public class Thuongtheodoanhso_EIUSALES {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		long[] levels = { 0, 20, 50, 200, 500, 2000, Integer.MAX_VALUE };
		double[] rate = { 0.02, 0.03, 0.04, 0.05, 0.06, 0.07 };
		double discount = 0;
		long income = 0;

		long money = reader.nextLong();

		for (int j = 0; j < rate.length; j++) {
			if (money >= levels[j]) {
				discount += (Math.min(levels[j + 1], money) - levels[j]) * rate[j];
			}
		}
		income += money - discount;

		System.out.println(Math.round(discount * 1000) / 1000.0);
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