import java.util.*;
import java.io.*;

public class Primedivisor_EIUPH006 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int answer = 0;
		for (int i = 2; i < n; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++)
				if (i % j == 0) {
					flag = false;
					break;
				}
			if (n % i == 0 && flag == true) {
				answer++;
			}
		}
		System.out.println(answer);
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