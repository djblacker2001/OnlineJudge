import java.util.*;
import java.io.*;

public class Tetholidaydiscount_EIINTEREST2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long receive = reader.nextLong();
		int time = reader.nextInt();
		double account = 0;
		double ans;
		long[] array = new long[time];
		for (int i = 0; i < time; i++) {
			array[i] = reader.nextLong();
		}
		for (double rate = 0;; rate += 0.0001) {
			for (int i = 0; i < time; i++) {
				account = (account + array[i]) * (1 + rate);
			}
			if (account >= receive) {
				System.out.println(Math.round(rate * 1000) / 1000.0);
				break;
			}
			account = 0;
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