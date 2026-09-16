import java.util.*;
import java.io.*;

public class Voucher3_EIVCHR1 {
	static InputReader reader = new InputReader(System.in);
	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();
		if (k > n) {
			k = n;
		}
		long pay = 0;
		double discount = 0;
		long[] price = new long[n];
		for (int i = 0; i < n; i++) {
			price[i] = reader.nextLong();
			pay += price[i];
		}
		Arrays.sort(price);
		for (int i = n - 1; k > 0; i--) {
			discount += Math.min(50000, price[i] * 0.3);
			k--;
		}
		System.out.print((long) pay - Math.round(discount));
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

