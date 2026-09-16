import java.util.*;
import java.io.*;

public class CountInversion_EIAPPLEBOX {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    static long[] temp;
    static long count = 0;
	
	public static void main(String[] args) {
        int testcase = reader.nextInt();
        for (int t = 0; t < testcase; t++) {
            int lenght = reader.nextInt();
            long a = reader.nextLong();
            long p = reader.nextLong();
            long[] arr = new long[lenght];
            count = 0;
            arr[0] = (a * a) % p;
            for (int i = 1; i < lenght; i++) {
                arr[i] = (arr[i - 1] * a) % p;
            }
            temp = new long[arr.length];
            mergeSort(arr, 0, arr.length - 1);
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static void mergeSort(long[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    static void merge(long[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid + 1 - i;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
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