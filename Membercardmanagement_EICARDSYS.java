import java.util.*;
import java.io.*;

public class Membercardmanagement_EICARDSYS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		HashMap<String, Long> customer = new HashMap<>();
		double total = 0;
		for (int i = 0; i < n; i++) {
			String id = reader.next();
			long price = reader.nextLong();
			long spend = customer.getOrDefault(id, 0L);
			double discountRate = getDiscountRate(spend);
			total += price * discountRate;
			customer.put(id, spend + price);
		}

		System.out.print(Math.round(total * 100) / 100D);
	}

	private static double getDiscountRate(long spending) {
		if (spending >= 200_000_000)
			return 0.07;
		if (spending >= 50_000_000)
			return 0.05;
		if (spending >= 20_000_000)
			return 0.03;
		if (spending >= 1_000_000)
			return 0.02;
		return 0.0;
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

		public char nextChar() {
			return next().charAt(0);
		}
	}
}
