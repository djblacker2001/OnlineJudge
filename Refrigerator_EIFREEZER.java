import java.util.*;
import java.io.*;

public class Refrigerator_EIFREEZER {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int L = reader.nextInt();
		int a = 1, b = 1, c = 1;

		double x = Math.cbrt(L);
		for (int i = 1; i < x; ++i) {
			if (L % i != 0)
				continue;
			double y = Math.sqrt(L / i);
			for (int j = i; j < y; ++j)
				if (L / i % j == 0) {
					c = L / i / j;
					a = i;
					b = j;
				}

		}
		System.out.println(c + " " + b + " " + a + " ");
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
