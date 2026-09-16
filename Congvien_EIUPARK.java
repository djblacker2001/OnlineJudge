import java.util.*;
import java.io.*;

public class Congvien_EIUPARK {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        long x1 = reader.nextLong();
        long y1 = reader.nextLong();
        long x2 = reader.nextLong();
        long y2 = reader.nextLong();
        long x3 = reader.nextLong();
        long y3 = reader.nextLong();
        long x4 = x1 ^ x2 ^ x3;
        long y4 = y1 ^ y2 ^ y3;
        System.out.println(x4 + " " + y4);
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
