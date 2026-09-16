import java.util.*;
import java.io.*;

public class EmployeesWorkingHours_EI2122Q1DSAF2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		Hashtable<Integer, Employees> list = new Hashtable<>();

		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			int time = reader.nextInt();

			if (list.get(id) == null) {
				Employees emp = new Employees(id);
				list.put(id, emp);
			}
			list.get(id).check(time);

		}
		
		List<Integer> keys = new ArrayList(list.keySet());
		keys.sort(null);
		for (Integer key : keys) {
			sb.append(list.get(key)).append("\n");
		}
		System.out.println(sb);
	}

	static class Employees {
		public int id;
		public int total;
		public int count = 1;
		public int check;

		public Employees(int id) {
			this.id = id;
		}

		public void check(int time) {
			if (count % 2 == 1) {
				check = time;
				count++;
			} else {
				total += (time - check);
				count++;
			}
		}

		@Override
		public String toString() {
			return id+" "+total;
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