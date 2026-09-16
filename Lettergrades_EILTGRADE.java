import java.util.*;
import java.io.*;

public class Lettergrades_EILTGRADE {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int p = reader.nextInt();
		int[] score = { 0, 49, 51, 52, 54, 59, 64, 69, 74, 79, 84, 89, 100 };
		String[] grade = { "F", "D-", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A" };
		int res = 0;
		for (int i = 0; i < 12; i++) {
			if (p <= score[i + 1] && p > score[i])
				res = i;
		}
		System.out.println(grade[res]);
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
