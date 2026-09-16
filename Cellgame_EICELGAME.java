import java.util.*;
import java.io.*;

public class Cellgame_EICELGAME {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = reader.nextInt();
        long[] val = new long[N];
        for (int i = 0; i < N; i++) {
            val[i] = reader.nextLong();
        }

        long[][] dp = new long[N][2];

        dp[0][0] = 2 * val[0];
        dp[0][1] = val[0];

        for (int i = 1; i < N; i++) {
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + val[i];    
            dp[i][0] = dp[i-1][1] + 2 * val[i];                     
        }

        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
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

