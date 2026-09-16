import java.util.*;
import java.io.*;

public class MinDistance_EIUMINDIST {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}

		Arrays.sort(arr);

		int left = 1, right = arr[n - 1] - arr[0];
		int answer = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (canSelectKElements(arr, n, k, mid)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}

	public static boolean canSelectKElements(int[] arr, int n, int k, int minDiff) {
		int count = 1;
		int lastPicked = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i] - lastPicked >= minDiff) {
				count++;
				lastPicked = arr[i];

				if (count == k) {
					return true;
				}
			}
		}
		return false;
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

		char nextChar() {
			return next().charAt(0);
		}
	}
}
