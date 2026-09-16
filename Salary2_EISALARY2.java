import java.util.*;
import java.io.*;

public class Salary2_EISALARY2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		double[] res = new double[n];
		double sum = 0, sumOver = 0, money = 0, moneyOver = 0;

		for (int i = 0; i < n; i++) {
			float total = 0, totalOver = 0;
			for (int j = 0; j < 5; j++) {
				double a = reader.nextDouble();
				if (a > 8) {
					total += 8;
					totalOver += a - 8;
				} else
					total += a;
			}
			double a = reader.nextDouble();
			money += total * a;
			moneyOver += totalOver * a * 1.5;
			res[i] = total * a + totalOver * a * 1.5;

			sum += total;
			sumOver += totalOver;

		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%.2f\n", res[i]);
		}
		if (sum > 0)
			System.out.printf("%.2f\n", money / sum);
		else
			System.out.println(0.0);
		if (sumOver > 0)
			System.out.printf("%.2f", moneyOver / sumOver);
		else
			System.out.println(0.0);
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
