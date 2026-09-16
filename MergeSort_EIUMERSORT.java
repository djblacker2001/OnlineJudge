import java.util.*;
import java.io.*;

public class MergeSort_EIUMERSORT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}
		mergeSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int nleft = mid - left + 1;
		int nright = right - mid;
		int[] leftArr = new int[nleft];
		int[] rightArr = new int[nright];
		for (int i = 0; i < nleft; i++)
			leftArr[i] = arr[left + i];
		for (int j = 0; j < nright; j++)
			rightArr[j] = arr[mid + 1 + j];
		int i = 0, j = 0, k = left;
		for (; i < nleft && j < nright; k++) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
		}
		for (; i < nleft; i++, k++) {
			arr[k] = leftArr[i];
		}

		for (; j < nright; j++, k++) {
			arr[k] = rightArr[j];
		}
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
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
