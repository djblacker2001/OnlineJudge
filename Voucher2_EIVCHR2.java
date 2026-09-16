import java.util.*;
import java.io.*;

public class Voucher2_EIVCHR2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextInt();
		}
		long Tinhtong = sum(arr);
		if (arr[maximum(arr)] * 30 / 100 < 50000) {
			System.out.println((long) Tinhtong - arr[maximum(arr)] * 30 / 100);
		} else {
			System.out.println((long) Tinhtong - 50000);
		}

	}

	public static int maximum(long[] e) {
		long max = e[0];
		int index = 0;
		for (int i = 1; i < e.length; i++)
			if (e[i] > max) {
				max = e[i];
				index = i;
			}
		return index;
	}

	public static long sum(long[] e) {
		long s = 0;
		for (int i = 0; i < e.length; i++)
			s += e[i];
		return s;

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
