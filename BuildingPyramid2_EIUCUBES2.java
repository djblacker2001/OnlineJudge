import java.util.*;
import java.io.*;

public class BuildingPyramid2_EIUCUBES2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			long a = reader.nextLong();
			arr[i] = layers(a);
		}
		output(arr);
	}

	public static long layers(long a) {
		long brick = 1, lv = 1;

		while (brick <= a) {
			a -= brick;
			lv++;
			brick += lv;
		}
		lv -= 1;

		return lv;
	}

	public static void output(long[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
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
