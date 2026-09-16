import java.util.*;
import java.io.*;

public class GiftWrapping_EIUGIFT1 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfGifts = reader.nextInt();
		int numberOfPapers = reader.nextInt();
		int[] sizeOfGifts = new int[numberOfGifts];
		int[] sizeOfPapers = new int[numberOfPapers];

		for (int i = 0; i < numberOfGifts; i++) {
			sizeOfGifts[i] = reader.nextInt();
		}
		Arrays.sort(sizeOfGifts);

		for (int i = 0; i < numberOfPapers; i++) {
			sizeOfPapers[i] = reader.nextInt();
		}
		Arrays.sort(sizeOfPapers);
		int count = 0;
		int j = 0;
		for (int gift : sizeOfGifts) {
            while (j < numberOfPapers && sizeOfPapers[j] < 2 * gift) {
                j++;
            }
            if (j < numberOfPapers && sizeOfPapers[j] <= 3 * gift) {
                count++;
                j++;
            }
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
	}
}
