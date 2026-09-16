import java.util.*;
import java.io.*;

public class AboveAverage_EIABOVEA {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int[] e = input();
		output(e);
		int Tinhtrungbinh = count(e);
		System.out.println(Tinhtrungbinh);
	}

	public static int[] input() {
		int n = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = reader.nextInt();
		return arr;
	}

	public static void output(int[] d) {
		for (int i = 0; i < d.length; i++)
			System.out.print("");
	}

	public static int count(int[] a) {
		int dem = 0;
		double total = 0;
		for (int i = 0; i < a.length; i++) {
			total = total + a[i];
		}
		double avg = total / a.length;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > avg)
				dem++;
		}
		return dem;
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
