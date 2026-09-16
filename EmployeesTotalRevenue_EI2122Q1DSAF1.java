import java.util.*;
import java.io.*;

public class EmployeesTotalRevenue_EI2122Q1DSAF1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		Hashtable<Integer, Employee> list = new Hashtable<>();
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			int quantity = reader.nextInt();
			int price = reader.nextInt();
			if (list.get(id) == null) {
				Employee employee = new Employee(id);

				list.put(id, employee);
			}
			list.get(id).sell(quantity, price);
		}

		ArrayList<Employee> employees = new ArrayList<>(list.values());
		employees.sort((s1, s2) -> {
			int compare = Long.compare(s2.totalRevenue, s1.totalRevenue);
			if (compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});

		for (int j = 0; j < employees.size(); j++) {
			sb.append(employees.get(j)).append("\n");
		}
		System.out.println(sb);

	}

	static class Employee {
		public int id;
		public long totalRevenue = 0;

		public Employee(int id) {
			this.id = id;
		}

		public void sell(int quantity, int price) {
			totalRevenue += (long) quantity * price;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(id).append(" ").append(totalRevenue);

			return sb.toString();
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