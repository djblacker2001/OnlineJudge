import java.util.*;
import java.io.*;

public class Giamgiatet_EIUDISCOUNT3 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long n = reader.nextLong();
		double[] rate = { 1, 0.97, 0.95, 0.93, 0.9, 0.88, 0.85 };
		long[] lv = { 0, 5_000_000, 20_000_000, 100_000_000, 300_000_000, 600_000_000, 900_000_000, Long.MAX_VALUE };

		long res = 0;

		for (int i = 0; i < 7; i++) {
			if (n > lv[i + 1])
				res += (lv[i + 1] - lv[i]) * rate[i];
			else {
				res += (n - lv[i]) * rate[i];
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			int a = reader.nextInt();
			if (a == 1)
				res *= 0.98;
		}
		System.out.println((long) res);

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
