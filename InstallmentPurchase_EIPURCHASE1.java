import java.util.*;
import java.io.*;

public class InstallmentPurchase_EIPURCHASE1 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long v = reader.nextLong();
		int t = reader.nextInt();
		long m = reader.nextLong();
		long monthly = reader.nextLong();
		double answer = 0;
		for (double r = 0;; r += 0.0001) {
			double x = v - m;
			for (int i = 0; i < t; i++) {
				x = x * (1 + r) - monthly;
			}
			if (x >= 0) {
				answer = r;
				break;
			}
		}
		System.out.printf("%.3f", answer);
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
