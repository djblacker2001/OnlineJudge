import java.util.*;
import java.io.*;

public class SelectionSort_EIUSESOR {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = reader.nextInt();
		}
		selectionSort(arr);
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;

		// Di chuyển ranh giới của mảng đã sắp xếp và chưa sắp xếp
		for (int i = 0; i < n - 1; i++) {
			// Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j; // Cập nhật chỉ số phần tử nhỏ nhất
				}
			}
			// Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của phần chưa sắp xếp
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
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
