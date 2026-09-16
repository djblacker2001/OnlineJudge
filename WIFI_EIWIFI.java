import java.util.*;
import java.io.*;

public class WIFI_EIWIFI {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long testcase = reader.nextLong();
		for (int i = 0; i < testcase; i++) {
			double tich = 0;
			double m = reader.nextDouble();
			double n = reader.nextDouble();
			m -= 2;
			n -= 2;
			m /= 3;
			n /= 3;
			tich = Math.ceil(m) * Math.ceil(n);
			double temp = 0;
			temp = tich;
			temp %= 10;
			if (temp >= 5)
				tich = Math.round(tich);
			else
				tich = Math.ceil(tich);
			System.out.println((long) tich);
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
