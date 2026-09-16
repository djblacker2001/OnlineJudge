import java.util.*;
import java.io.*;

public class Permutation_EIEQUALS {
	static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt(); 
		int totalDiffer = n;
		
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		Hashtable<Integer, Integer> map = new Hashtable<>();
		int sum1 = 0; 
		int sum2 = 0;
		int num = 0;
		for (int i = 0; i < n; i++) {
			num = reader.nextInt();
			sum1 += num;
			arr1.add(num);
			
			if(map.get(num) == null) {
				map.put(num, 0);
			}
			map.put(num, map.get(num)+1);
		}
		
		for (int i = 0; i < n; i++) {
			num = reader.nextInt();
			sum2 += num;
			arr2.add(num);
			
			if(map.get(num) == null) {
				continue;
			}
			
			if( map.get(num) != 0) {
				totalDiffer--;
				map.put(num, map.get(num) -1);
			}
		}
		Collections.sort(arr1);
		Collections.sort(arr2);
		
		
		if (Math.abs(sum1 - sum2) <= k) {
			if(totalDiffer <= 1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}else {
			System.out.println("NO");
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
