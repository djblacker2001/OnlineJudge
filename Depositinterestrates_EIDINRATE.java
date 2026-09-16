import java.util.*;
import java.io.*;

public class Depositinterestrates_EIDINRATE {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			double x = reader.nextDouble();
			double y = reader.nextDouble();
			double z = reader.nextDouble();
			double res = Math.floor(Math.log10(x / z) / Math.log10((y / 100) + 1));
			a[i] = (int) (-res);
		}
		output(a);
	}

	public static void output(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
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