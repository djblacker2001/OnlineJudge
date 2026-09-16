import java.util.*;
import java.io.*;

public class pangram_EIALPHABET {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		int n = reader.nextInt();
		for (int i = 0; i < n; i++) {
			StringBuilder str = new StringBuilder();
			str.append("abcdefghijklmnopqrstuvwxyz");
			String input = reader.nextLine();
			input = input.replaceAll("\\s", "");
			input = input.toLowerCase();
			for (int j = 0; j < input.length(); j++) {
				for (int k = 0; k < str.length(); k++) {
					if (input.charAt(j) == (str.charAt(k))) {
						str.deleteCharAt(k);
						break;
					}
				}
			}
			if (str.length() != 0) {
				System.out.println("missing " + str);
			} else {
				System.out.println("pangram");
			}
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