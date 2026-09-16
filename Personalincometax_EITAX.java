import java.util.*;
import java.io.*;

public class Personalincometax_EITAX {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long n = reader.nextLong();
		long money = n - 9000000;
		if (money < 0)
			System.out.print(money * 0);
		else if (money <= 5000000 && money > 0)
			System.out.print(money * 5 / 100);
		else if (money > 5000000 && money <= 10000000)
			System.out.print(money * 10 / 100 - 250000);
		else if (money > 10000000 && money <= 18000000)
			System.out.print(money * 15 / 100 - 750000);
		else if (money > 18000000 && money <= 32000000)
			System.out.print(money * 20 / 100 - 1650000);
		else if (money > 32000000 && money <= 52000000)
			System.out.print(money * 25 / 100 - 3250000);
		else if (money > 52000000 && money <= 80000000)
			System.out.print(money * 30 / 100 - 5850000);
		else if (money > 80000000)
			System.out.print(money * 35 / 100 - 9850000);
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