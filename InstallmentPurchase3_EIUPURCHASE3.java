import java.util.*;
import java.io.*;

public class InstallmentPurchase3_EIUPURCHASE3 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long price = reader.nextLong();
		long paid = reader.nextLong();
		int time = reader.nextInt();
		double rate = reader.nextDouble();
		long debt = price - paid;
		double monthlyPayment = Math.floor((debt * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1));
		System.out.println((long) monthlyPayment);
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

		public boolean hasNext() throws IOException {
			if (tokenizer != null && tokenizer.hasMoreTokens()) {
				return true;
			}
			temp = reader.readLine();
			return (temp != null && temp.length() > 0);
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