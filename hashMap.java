import java.util.*;
import java.io.*;

public class hashMap {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		HashMap<String,Integer> banggia = new HashMap<>(); 
		banggia.put("a", 10000);
		banggia.put("b", 12000);
		banggia.put("c", 14000);
		banggia.put("d", 16000);
		banggia.put("e", 19000);
		System.out.println(banggia.get("b"));
		System.out.println(banggia.values());
		for (String pho : banggia.keySet()) {
			System.out.println(pho+":"+banggia.get(pho));
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
