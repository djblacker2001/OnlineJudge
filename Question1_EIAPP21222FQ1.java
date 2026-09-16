import java.util.*;
import java.io.*;

public class Question1_EIAPP21222FQ1 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		double res = 0;

		double[] I = { 0.039, 0.0392, 0.0395, 0.0399, 0.0404, 0.0554, 0.0572, 0.0592, 0.0614, 0.0638, 0.0664, 0.0692 };
		double a = I[(m % 12) - 1];
		if (m <= 11)
			res = n * (1 + I[m - 1] * m / 12);
		else {
			res = n;
			for (int i = 0; i < m / 12; i++)
				res = res * (1 + I[11]);
			res = res * (1 + I[(m % 12) - 1] * (m % 12) / 12);
		}
		System.out.println(Math.round(res));

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