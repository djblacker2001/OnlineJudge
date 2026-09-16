import java.util.*;
import java.io.*;

public class EveryNumber_EIEVERYN {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int x = reader.nextInt();
		for (int i = 0; i < x; i++) {
			int m = reader.nextInt();
			int n = reader.nextInt();
			int[] arr = new int[m];
			for (int l = 0; l < m; l++)
				arr[l] = reader.nextInt();

			boolean flag = true;
			for (int j = 1; j <= n; j++) {
				boolean flag2 = false;
				for (int k = 0; k < arr.length; k++) {

					if (arr[k] == j) {
						flag2 = true;
						break;
					}
				}
				if (flag2 == false) {
					flag = false;
					break;
				}

			}
			if (flag)
				System.out.println("Yes");
			else
				System.out.println("No");
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