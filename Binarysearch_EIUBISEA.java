import java.util.*;
import java.io.*;

public class Binarysearch_EIUBISEA {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		int narr[] = new int[n];
		for (int i = 0; i < n; i++) {
			narr[i] = reader.nextInt();
		}
		int marr[] = new int[m];
		for (int i = 0; i < m; i++) {
			marr[i] = reader.nextInt();
		}
		Arrays.sort(narr);
		for (int q : marr) {
			sb.append(binary(narr, q)).append(" ");
		}

		System.out.println(sb);
	}

	public static int binary(int[] arr, int x) {
		int right = arr.length - 1;
		int left = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < x) {
				left = mid + 1;
			} else if (arr[mid] > x) {
				right = mid - 1;
			} else {
				while (mid > 0 && arr[mid - 1] == x) {
					mid--;
				}
				return mid;
			}
		}
		return -1;
	}

	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		char nextChar() {
			return next().charAt(0);
		}
	}
}
