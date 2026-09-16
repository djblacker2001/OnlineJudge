import java.util.*;
import java.io.*;

public class Logfiles_EIULOGFILE {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		List<Long> arr = new ArrayList<Long>(number);
		for (long i = 0; i < number; i++) {
			arr.add(reader.nextLong());
		}
		arr.sort(null);
		long count = 0;
		int j = 1;
		for (int i = 0; i < arr.size() - 1; i++) {
			for (; j < arr.size(); j++) {
				if (arr.get(j) - arr.get(i) > 600000) {
					break;
				}
				count += j - i;
			}
		}
		System.out.println(count);
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