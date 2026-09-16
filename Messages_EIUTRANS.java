import java.io.*;
import java.util.*;

public class Messages_EIUTRANS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int numberofwords = reader.nextInt();
		int numberofkeys = reader.nextInt();
		
		// Khoi tao hashmap
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < numberofkeys; i++) {
			String a = reader.next();
			String b = reader.next();
			if (!map.containsKey(a)) {
				// da cap nhat key value
				map.put(a, b);
			}
		}
		for (int i = 0; i < numberofwords; i++) {
			String word = reader.next();
			String value = map.get(word);
			if (value.length() < word.length()) {
				sb.append(value).append(" ");
			} else {
				sb.append(word).append(" ");
			}
		}
		System.out.println(sb);
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
