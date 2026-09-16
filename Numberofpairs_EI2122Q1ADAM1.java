import java.util.*;
import java.io.*;

public class Numberofpairs_EI2122Q1ADAM1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {
        int n = reader.nextInt();
        int X = reader.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = reader.nextInt();
        }
        System.out.println(countPairs(n, X, numbers));
    }

    public static int countPairs(int n, int x, int[] numbers) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : numbers) {
            if (freqMap.containsKey(num - x)) {
                count += freqMap.get(num - x);
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
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
