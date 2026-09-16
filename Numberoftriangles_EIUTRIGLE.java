import java.util.*;
import java.io.*;

public class Numberoftriangles_EIUTRIGLE {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}
		int ans = TrianglesCount(arr, n);
		System.out.println(ans);
	}

	public static int TrianglesCount(int arr[], int n) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < n - 2; ++i) {
			int k = i + 2;
			for (int j = i + 1; j < n; ++j) {
				while (k < n && arr[i] + arr[j] > arr[k])
					++k;
				if (k > j)
					count += k - j - 1;
			}
		}
		return count;
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