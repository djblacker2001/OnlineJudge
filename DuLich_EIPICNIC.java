import java.util.*;
import java.io.*;

class DuLich_EIPICNIC {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] groups = new int[5];
		long numberOfCars = 0;
		for (int i = 0; i < n; i++) {
			int numberOfPeople = reader.nextInt();
			groups[numberOfPeople]++;
		}
		numberOfCars += groups[4];
		numberOfCars += groups[3];
		if (groups[1] > groups[3]) {
			groups[1] -= groups[3];
		} else {
			groups[1] = 0;
		}

		numberOfCars += groups[2] / 2;
		if (groups[2] % 2 == 1) {
			numberOfCars += 1;
			groups[1] = Math.max(0, groups[1] - 2);
		}

		numberOfCars += (groups[1]) / 4;
		groups[1] %= 4;
		if (groups[1] > 0) {
			numberOfCars++;
		}
		System.out.println(numberOfCars);

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