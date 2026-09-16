import java.util.*;
import java.io.*;

public class DistinctNumbers_EI20213Q2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
        // Đọc số lượng phần tử
        int n = reader.nextInt();
        // Sử dụng HashMap để lưu tần suất của các giá trị
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Đọc danh sách các số và cập nhật tần suất
        for (int i = 0; i < n; i++) {
            int value = reader.nextInt();
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        // Chuyển các giá trị duy nhất thành danh sách và sắp xếp
        List<Integer> uniqueValues = new ArrayList<>(frequencyMap.keySet());

        // Xuất kết quả
        for (int value : uniqueValues) {
            System.out.println(value + " " + frequencyMap.get(value));
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
