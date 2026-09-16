import java.util.*;
import java.io.*;

public class TophighestGPA_EISTULI {
	static InputReader reader = new InputReader(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String id = reader.next();
			String name = reader.next();
			Student st = new Student(id, name);
			int noCourses = reader.nextInt();
			for (int j = 0; j < noCourses; j++) {
				int score = reader.nextInt();
				int credits = 4;
				st.addGrade(score, credits);
			}
			students.add(st);
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			return compare;
		});

		if (students.size() == k) {
			for (Student student : students) {
				sb.append(student).append("\n");
			}
		} else {
			for (int i = 0; i < k; i++) {
				if (students.get(i).gpa != students.get(k).gpa) {
					sb.append(students.get(i) + "\n");
				} else {
					break;
				}
			}
		}
		System.out.println(sb);
	}

	static class Student {
		String id;
		String name;
		int noCredits;
		double gpa;
		double total;

		public Student(String id, String name) {
			this.id = id;
			this.name = name;
		}

		void addGrade(int score, int credits) {
			if (score >= 50) {
				total += score * credits;
				noCredits += credits;
				gpa = total / noCredits;
			}
		}

		@Override
		public String toString() {
			return id + " " + name + " " + gpa + " " + noCredits;
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
