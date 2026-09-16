import java.io.*;
import java.util.*;

public class GetKConsecutiveBlackBlocks_EISWMED1 {
    static InputReader reader = new InputReader(System.in);
    public static void main(String[] args) {
        String B = reader.next();
        int k = reader.nextInt();
        int n = B.length();

        int whiteCount = 0;

        for (int i = 0; i < k; i++) {
            if (B.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        int minOperations = whiteCount;

        for (int i = k; i < n; i++) {
            if (B.charAt(i - k) == 'W') {
                whiteCount--;
            }
            if (B.charAt(i) == 'W') {
                whiteCount++;
            }
            minOperations = Math.min(minOperations, whiteCount);
        }

        System.out.println(minOperations);
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
