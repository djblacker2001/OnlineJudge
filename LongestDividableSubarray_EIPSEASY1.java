import java.util.*;
import java.io.*;

public class LongestDividableSubarray_EIPSEASY1 {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int N = reader.nextInt();
        int K = reader.nextInt();
        long prefixSum = 0;
        int maxLen = 0;

        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, 0);

        for (int i = 1; i <= N; i++) {
            prefixSum += reader.nextInt();

            int mod = (int)((prefixSum % K + K) % K);

            if (firstIndex.containsKey(mod)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(mod));
            } else {
                firstIndex.put(mod, i);
            }
        }

        System.out.println(maxLen);
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
