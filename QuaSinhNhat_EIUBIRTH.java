import java.util.*;
import java.io.*;

public class QuaSinhNhat_EIUBIRTH {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int t = reader.nextInt();
		long[] arr = new long[t];
		for (int i = 0; i < t; i++) {
			long b = reader.nextLong();
			long r = reader.nextLong();
			int x = reader.nextInt();
			int y = reader.nextInt();
			int z = reader.nextInt();
			arr[i] = res(b, r, x, y, z);
		}
		output(arr);
	}

	public static long res(long b, long r, int x, int y, int z) {

		long re = 0, m = 0, n = 0;

		if (x > y + z) {
			m = b * (y + z);
			n = r * y;
			re = m + n;
		}

		else if (y > x + z) {
			m = b * x;
			n = r * (x + z);
			re = m + n;
		} else
			re = b * x + r * y;
		return re;
	}

	public static void output(long[] a) {
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