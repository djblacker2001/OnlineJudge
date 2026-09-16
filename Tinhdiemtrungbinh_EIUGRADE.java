import java.util.*;
import java.io.*;

public class Tinhdiemtrungbinh_EIUGRADE {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		HashMap<Integer, Student> stu = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			int subject = reader.nextInt();
			if (stu.get(id) == null) {
				Student st = new Student(id);
				double grade = reader.nextDouble();
				st.addScore(grade);
				stu.put(id, st);
			} else {
				double grade = reader.nextDouble();
				stu.get(id).addScore(grade);
			}
		}

		LinkedHashMap<Integer, Double> sortedMap = new LinkedHashMap<>();
		stu.entrySet().stream().sorted((s1, s2) -> {
			int compare = Double.compare(s2.getValue().gpa, s1.getValue().gpa);
			if (compare == 0) {
				compare = Integer.compare(s1.getKey(), s2.getKey());
			}
			return compare;

		}).forEachOrdered(p -> sortedMap.put(p.getKey(), p.getValue().gpa));
		sortedMap.forEach((key, val) -> sb.append(key + " " + val + "\n"));

		System.out.println(sb);
	}

	static class Student {
		int id;
		double grade = 0;
		int count = 0;
		double gpa = 0;

		public Student(int id) {
			this.id = id;

		}

		public void addScore(double grades) {
			grade += grades;
			count++;
			gpa = grade / count;
		}

		@Override
		public String toString() {
			return id + " " + gpa;
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
