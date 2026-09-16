import java.util.*;
import java.io.*;

public class HomeLoan_EIUBHOUSE {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long n = reader.nextLong();
		long m = reader.nextLong();
		int k = reader.nextInt();
		double rate = reader.nextDouble() / 100;
		double debt0 = n - m, debt = debt0;
		double pay0 = debt0 / k;
		long res = 0;
		for (int i = 0; i < k; i++) {
			double I = debt * rate;
			res = (long) (Math.round(I + pay0));
			debt -= pay0;
			System.out.println(i + 1 + " " + res);
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
