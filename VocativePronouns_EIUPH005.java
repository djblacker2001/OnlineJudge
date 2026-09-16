import java.util.*;
import java.io.*;

public class VocativePronouns_EIUPH005 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int age = reader.nextInt();
		String gender = reader.next();
		relationship(age, gender);
	}

	public static void relationship(int age, String gender) {
		if (age <= 20) {
			System.out.println(age <= 5 ? "Be" : "Em");
		} else {
			if (gender.equals("Nam")) {

				System.out.println(age <= 35 ? "Anh" : (age <= 60 ? "Chu" : "Ong"));

			} else if (gender.equals("Nu")) {
				System.out.println(age <= 35 ? "Chi" : (age <= 60 ? "Co" : "Ba"));
			}

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