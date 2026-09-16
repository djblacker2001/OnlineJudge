import java.util.*;
import java.io.*;

public class QuickSort_EIUQUISORT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}
		quickSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}

	public static void quickSort(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int pivot = arr[left + (right - left) / 2];
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (pivot < arr[j]) {
				j--;
			}
			if (i <= j) {
				swap(arr, i++, j--);
			}
		}
		if (i < right) {
			quickSort(arr, i, right);
		}
		if (left < j) {
			quickSort(arr, left, j);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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
