import java.util.*;
import java.io.*;

public class Matching_EI2122Q1ADAM2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
        int N = reader.nextInt();
        int M = reader.nextInt();
        int X = reader.nextInt();
        
        int[] men = new int[N];
        for (int i = 0; i < N; i++) {
            men[i] = reader.nextInt();
        }
        
        int[] women = new int[M];
        for (int i = 0; i < M; i++) {
            women[i] = reader.nextInt();
        }
        System.out.println(findMinH(men, women, X));
    }
	
    public static int findMinH(int[] men, int[] women, int X) {
        Arrays.sort(men);
        Arrays.sort(women);
        int left = 0, right = Math.max(men[men.length - 1], women[women.length - 1]);
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canFormXPairs(men, women, X, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    public static boolean canFormXPairs(int[] men, int[] women, int X, int maxDiff) {
        int i = 0, j = 0, count = 0;
        
        while (i < men.length && j < women.length) {
            if (Math.abs(men[i] - women[j]) <= maxDiff) {
                count++;
                i++;
                j++;
                if (count == X) return true;
            } else if (men[i] < women[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return count >= X;
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