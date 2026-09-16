import java.util.*;
import java.io.*;

public class Distinctvalue_EIUONCE {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int testcase = reader.nextInt();
		for (int i = 0; i < testcase; i++) {
			int n = reader.nextInt();
			long[] arr = new long[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = reader.nextLong();
			}
			Arrays.sort(arr);
			if (arr[0] < arr[1])
				sb.append(arr[0] + " ");

			for (int j = 1; j < arr.length - 1; j++) {
				if (arr[j] != arr[j + 1] && arr[j] != arr[j - 1])
					sb.append(arr[j] + " ");
			}
			if (arr[n - 1] != arr[n - 2]) {
				sb.append(arr[n - 1] + " ");
			}
			sb.append("\n");

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
