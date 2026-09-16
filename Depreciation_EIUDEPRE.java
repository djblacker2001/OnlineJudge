import java.util.*;
import java.io.*;

public class Depreciation_EIUDEPRE {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws java.lang.Exception {
		int n = reader.nextInt();
		long c = reader.nextLong();
		long r = reader.nextLong();
		double x = 0, ans = 0;
		for (; x < 1; x += 0.000001) {
			double price = c;
			double rate = x;
			double temp = x / n;
			for (int i = 0; i < n; ++i) {

				price = price - price * rate;
				rate -= temp;
			}

			if (price >= r)
				ans = x;
			else
				break;
		}
		System.out.printf("%.7f", ans);
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