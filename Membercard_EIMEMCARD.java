import java.util.*;
import java.io.*;

public class Membercard_EIMEMCARD {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		double[] res = new double[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			long a = reader.nextLong();
			res[i] = dis(sum, a);
			sum += a;
		}
		for (int i = 0; i < n; i++)
			System.out.print(res[i] + " ");
	}

	public static double dis(long sum, long a) {
		double dis = a;
		double[] rate = { 0, 0.02, 0.03, 0.05, 0.07 };
		long[] lv = { 1_000_000, 20_000_000, 50_000_000, 200_000_000, Long.MAX_VALUE };

		for (int i = 0; i < 5; i++)
			if (sum < lv[i]) {
				dis *= rate[i];
				break;
			}
		return dis;
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
