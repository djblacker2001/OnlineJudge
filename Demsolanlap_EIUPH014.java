import java.util.*;
import java.io.*;

public class Demsolanlap_EIUPH014 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		while (true) {
			int n = reader.nextInt();
			if (n == 0)
				break;

			List<Integer> sequence = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				sequence.add(reader.nextInt());
			}

			System.out.println(countIterations(n, sequence));
		}
	}

	public static int countIterations(int n, List<Integer> sequence) {
		int iterations = 0;
		while (iterations < 1000) {
			boolean allEqual = true;
			int first = sequence.get(0);
			for (int num : sequence) {
				if (num != first) {
					allEqual = false;
					break;
				}
			}
			if (allEqual)
				return iterations;

			List<Integer> newSequence = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				newSequence.add(Math.abs(sequence.get(i) - sequence.get((i + 1) % n)));
			}
			sequence = newSequence;
			iterations++;
		}

		return -1;
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
