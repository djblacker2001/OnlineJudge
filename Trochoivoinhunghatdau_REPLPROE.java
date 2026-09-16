import java.util.*;
import java.io.*;

public class Trochoivoinhunghatdau_REPLPROE {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int n = reader.nextInt();
        long[] a = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            a[i] = reader.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            if (a[i] < i) {
                System.out.println("No");
                return;
            }
            a[i] -= i;
            a[i - 1] += a[i];
        }

        System.out.println("Yes");
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
