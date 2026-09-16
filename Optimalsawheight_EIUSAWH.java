import java.util.*;
import java.io.*;

public class Optimalsawheight_EIUSAWH {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int N = reader.nextInt();
        long M = reader.nextLong();

        int[] a = new int[N];
        int maxH = 0;

        for (int i = 0; i < N; i++) {
            a[i] = reader.nextInt();
            if (a[i] > maxH) maxH = a[i];
        }

        long left = 0;
        long right = maxH;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long total = 0;
            for (int h : a) {
                if (h > mid) total += (h - mid);
            }

            if (total >= M) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

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
