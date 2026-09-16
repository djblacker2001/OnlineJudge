import java.util.*;
import java.io.*;

public class Buygifts_EIPAIR {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int testcase = reader.nextInt();
		for (int t = 0; t < testcase; t++) {
			int values = reader.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < values; i++) {
				int price = reader.nextInt();
				map.put(price, map.getOrDefault(price, 0) + 1);
			}
			long total = 0;
			for (int freq : map.values()) {
				if (freq > 1) {
					total += ((double) (freq - 1)) / 2 * freq;

				}
			}

			sb.append(total).append("\n");
		}

		System.out.print(sb);

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
