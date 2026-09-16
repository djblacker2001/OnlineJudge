import java.util.*;
import java.io.*;

public class EIU_EIUPREIU {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int space = n / 2;
		sb.append(" " + "_".repeat(space) + " ".repeat(space + 5) + "\n");
		for (int i = 0; i < space - 1; i++) {
			sb.append("|"+" ".repeat(space+1)+"|"+" "+"|"+" ".repeat(space)+"|"+"\n");
		}
		sb.append("|" + "_".repeat(space) + " "+"|"+" "+"|"+" ".repeat(space) + "|").append("\n");
		for (int i = 0; i < space - 1; i++) {
			sb.append("|"+" ".repeat(space+1)+"|"+" "+"|"+" ".repeat(space)+"|"+"\n");
		}
		sb.append("|" + "_".repeat(space) + " "+"|"+" "+"|"+"_".repeat(space) + "|");
		System.out.println(sb);

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
