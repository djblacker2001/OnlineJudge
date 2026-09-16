import java.util.*;
import java.io.*;

public class Firstoccurrence_EIUPH011 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextInt();
		}
		for (int i = 1; i < arr.length; i++) {
			if (find_x(arr, arr[i], i)) {
				arr = xoa_vi_tri(arr, i);
				i--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] xoa_vi_tri(int[] a, int k) {
		int[] brr = new int[a.length - 1];
		for (int i = 0; i < k; i++) {
			brr[i] = a[i];
		}
		for (int i = k; i < brr.length; i++) {
			brr[i] = a[i + 1];
		}
		return brr;
	}
	
	// viết hàm tìm 1 phần tử đã xuất hiện chưa, từ vị trí 0 đến vị trí i
	public static boolean find_x(int[] a, int x, int i) {
		for (int j = 0; j < i; j++)
			if (a[j] == x) {
				return true;
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

		public boolean hasNext() throws IOException {
			if (tokenizer != null && tokenizer.hasMoreTokens()) {
				return true;
			}
			temp = reader.readLine();
			return (temp != null && temp.length() > 0);
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