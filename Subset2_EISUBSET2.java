import java.io.*;
import java.util.*;

public class Subset2_EISUBSET2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		int numArr = reader.nextInt();
		int sumSub = reader.nextInt();
		int[] arr = new int[numArr];

		int i = 0;
		for (; i < numArr; i++) {
			arr[i] = reader.nextInt();
		}

		combineWay(arr, sumSub);
	}

	public static void combineWay(int[] arr, int sumSub) {
		int numSub = arr.length;
		List<Integer> listTotal = new ArrayList<>();
		int count = 0;
		for (int i = numSub - 1; i >= 0; i--) {
			List<Integer> tempTotal = new ArrayList<>();
			int num = arr[i];
			tempTotal.add(num);

			if (num == sumSub)
				count++;

			int end = listTotal.size();
			for (int j = 0; j < end; j++) {
				int numT = num + listTotal.get(j);
				tempTotal.add(numT);
				if (numT == sumSub)
					count++;
			}
			listTotal.addAll(tempTotal);
		}
		System.out.println(count);

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

		public char nextChar() {
			return next().charAt(0);
		}
	}
}
