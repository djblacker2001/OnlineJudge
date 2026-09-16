import java.util.*;
import java.io.*;

public class Thetindung_EIUCREDIT {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		double total = 0;
		double r = reader.nextDouble();
		int end = reader.nextInt();
		int nextMonth = 31;
		double debt = 0;
		int previous = 0;
		for (int i = 0; i <= n; i++) {
			int time = (i < n) ? reader.nextInt() : end;
			Long amount = (i < n) ? reader.nextLong() : 0;
			if (time < nextMonth) {
				debt += Math.min(0, total) * (time - previous);

			} else {
				debt += Math.min(0, total) * (nextMonth - previous);
				while (nextMonth <= time) {
					total += debt * r / 30;
					previous = nextMonth;
					nextMonth += 30;
					debt = (time >= nextMonth) ? Math.min(0, total) * 30 : 0;

				}
				debt += Math.min(0, total) * (time - previous);
			}
			total += amount;
			previous = time;
		}
		System.out.println(total);
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