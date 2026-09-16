import java.util.*;
import java.io.*;

public class EarnedCredits_EIUCRDT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int course = reader.nextInt();
		Hashtable<String, Integer> courses = new Hashtable<>();
		int total = 0;

		for (int i = 0; i < course; i++) {
			String id = reader.next();
			int credit = reader.nextInt();

			courses.put(id, credit);
		}

		for (int j = 0; j < course; j++) {
			int score = reader.nextInt();
			String id = reader.next();

			if (score >= 50) {
				total += courses.get(id);
			}
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