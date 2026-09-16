import java.util.*;
import java.io.*;

public class Happynumber_EIFLPEASY1 {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int q = reader.nextInt();
        for (int i = 0; i < q; i++) {
            int n = reader.nextInt();
            if(isHappy(n)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }
    
    private static int nextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    private static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = nextNumber(n);
        }
        return n == 1;
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
