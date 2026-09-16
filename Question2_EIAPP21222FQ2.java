import java.util.*;
import java.io.*;

public class Question2_EIAPP21222FQ2 {
	static InputReader reader = new InputReader(System.in);
	static double[] I = { 0.039, 0.0392, 0.0395, 0.0399, 0.0404, 0.0554, 0.0572, 0.0592, 0.0614, 0.0638, 0.0664,
			0.0692 };

	public static void main(String[] args) {

		double res = 0;
		int n = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = reader.nextInt();

		if (n <= 11)
			result1(arr, n);
		else
			result2(arr, n);
	}

	public static void result1(int[] x, int n) {
		double res = 0;
		for (int i = 0; i < n; i++)
			res += x[i] * (1 + I[n - 1 - i] * (n - i) / 12);

		System.out.println(Math.round(res));

	}

	public static void result2(int[] x, int n) {
		double res = 0;
		int a = n / 12;
		for (int i = 0; i < n - 12; i++) {
			res = res + x[i] * Math.pow(1 + I[11], a);
			if ((i + 1) % 12 == 0)
				a--;
		}

		for (int i = n - 12; i < n; i++) {
			double r = I[n - 1 - i];
			res += x[i] * (1 + I[n - 1 - i] * (n - i) / 12);

		}
		System.out.println(Math.round(res));
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