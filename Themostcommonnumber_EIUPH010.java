import java.util.*;
import java.io.*;

public class Themostcommonnumber_EIUPH010 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		int maxFrequency = 0;
		int result = Integer.MAX_VALUE;

		// Đếm tần số và xác định kết quả
		for (int num : arr) {
			int freq = frequencyMap.getOrDefault(num, 0) + 1;
			frequencyMap.put(num, freq);

			// Cập nhật kết quả nếu tần suất cao hơn hoặc bằng nhau nhưng số lượng nhỏ hơn
			if (freq > maxFrequency || (freq == maxFrequency && num < result)) {
				maxFrequency = freq;
				result = num;
			}
		}
		System.out.println(result + " " + maxFrequency);
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
