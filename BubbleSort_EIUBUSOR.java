import java.util.*;
import java.io.*;

public class BubbleSort_EIUBUSOR {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        String[] firstLine = reader.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        String dataType = firstLine[1];
        String[] secondLine = reader.nextLine().split(" ");
        Number[] arr = null;
        
        switch (dataType) {
            case "int":
            case "long":
                arr = Arrays.stream(secondLine).map(Long::parseLong).toArray(Long[]::new);
                break;
            case "double":
            case "float":
                arr = Arrays.stream(secondLine).map(Double::parseDouble).toArray(Double[]::new);
                break;
        }
        bubbleSort(arr);
        
        for (Number num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void bubbleSort(Number[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].doubleValue() > arr[j + 1].doubleValue()) {
                    Number temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
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
