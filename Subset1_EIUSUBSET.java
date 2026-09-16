import java.util.*;
import java.io.*;

public class Subset1_EIUSUBSET {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int numSub = reader.nextInt();
        int com = (int) Math.pow(2, numSub);

        int[] arr = new int[numSub];
        
        for(int i=0; i<numSub; i++) {
            arr[i]=reader.nextInt();
        }

        
        binaryWay(arr);

    }

    public static String binaryWay(int [] arr) {
        int numSub = arr.length;
        int com = (int) Math.pow(2, numSub);
        
        int counter = 0;
        int total = 0;
        for (counter = 0; counter < com; counter++) {
            for (int j = numSub-1; j>=0; j--) {
                int g = 1 << j;
                if((counter & (1 << j)) >0) {
                    sb.append(arr[numSub-j-1]).append(" ");
                }
            }
            sb.append("\n");
            total++;
        }
        System.out.println(total-1);
        System.out.print(sb.toString());
        
        return sb.toString();
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

		public char nextChar() {
			return next().charAt(0);
		}
	}
}
