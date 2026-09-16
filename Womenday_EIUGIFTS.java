import java.util.*;
import java.io.*;

public class Womenday_EIUGIFTS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = reader.nextInt();
		}
		Arrays.sort(prices);

		// Khởi tạo hai con trỏ
		int left = 0;
		int right = prices.length - 1;

		// Biến lưu kết quả tốt nhất
		int maxTotal = -1;
		int minDiff = k;
		int bestLeft = -1;
		int bestRight = -1;

		// Duyệt qua hai con trỏ
		while (left < right) {
			int total = prices[left] + prices[right];
			int difference = prices[right] - prices[left];

			if (total <= k) { // Nếu tổng không vượt quá k
				// Cập nhật kết quả nếu tổng lớn hơn và chênh lệch nhỏ hơn
				if (total > maxTotal || (total == maxTotal && difference < minDiff)) {
					maxTotal = total;
					minDiff = difference;
					bestLeft = prices[left];
					bestRight = prices[right];
				}

				left++; // Di chuyển con trỏ trái để tăng tổng
			} else {
				right--; // Giảm con trỏ phải để giảm tổng
			}
		}

		// Kiểm tra kết quả cuối cùng
		if (maxTotal==-1) {
			System.out.println(bestLeft + " " + bestRight);
		} else {
			System.out.println(maxTotal + " " + minDiff);
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
