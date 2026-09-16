import java.util.*;
import java.io.*;

public class Fingers_EIUFING {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		if ((n - 1) % 18 == 0)
			System.out.print("Ngon cai cua ban tay trai");
		else if ((n - 10) % 18 == 0)
			System.out.print("Ngon cai cua ban tay phai");
		else if (n % 18 == 0 || (n - 2) % 18 == 0)
			System.out.print("Ngon tro cua ban tay trai");
		else if ((n - 9) % 18 == 0 || (n - 9) % 18 == 2)
			System.out.print("Ngon tro cua ban tay phai");
		else if ((n - 3) % 18 == 0 || (n - 3) % 18 == 14)
			System.out.print("Ngon giua cua ban tay trai");
		else if ((n - 8) % 18 == 0 || (n - 8) % 18 == 4)
			System.out.print("Ngon giua cua ban tay phai");
		else if ((n - 4) % 18 == 0 || (n - 4) % 18 == 12)
			System.out.print("Ngon ap ut cua ban tay trai");
		else if ((n - 7) % 18 == 0 || (n - 7) % 18 == 6)
			System.out.print("Ngon ap ut cua ban tay phai");
		else if ((n - 5) % 18 == 0 || (n - 5) % 18 == 10)
			System.out.print("Ngon ut cua ban tay trai");
		else
			System.out.print("Ngon ut cua ban tay phai");
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
