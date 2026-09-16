import java.util.*;
import java.io.*;

public class BlackFriday_EIAUCTION {
	static InputReader reader = new InputReader(System.in);
	public static void main(String[] args) {
		int t = reader.nextInt();
		int maxunique = 0;
		int count[] = new int[7];
		int value[] = new int[t];
		for (int i = 0; i < t; i++) {
			value[i] = reader.nextInt();
			count[value[i]]++;
		}
		for (int i = 6; i > 0; i--) {
			if (count[i] == 1) {
				maxunique = i;
				break;
			} else {
				maxunique = 0;
			}
		}
		if (maxunique > 0) {
			for (int i = t - 1; i >= 0; i--) {
				if (value[i] == maxunique) {
					System.out.println(i + 1);
					return;
				}
			}
		} else
			System.out.println("none");
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
