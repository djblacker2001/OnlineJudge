import java.util.*;
import java.io.*;

public class GPA_EICREDI2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String name = reader.next();
			int numberofCourse = reader.nextInt();
			Student student = new Student(name);
			for (int j = 0; j < numberofCourse; j++) {
				int grade = reader.nextInt();
				student.addGrade(grade);
			}
			students.add(student);
		}
		for (Student student : students) {
			sb.append(student).append("\n");
		}
		System.out.print(sb);
	}

	static class Student {
		public String name;
		public int numberofcourse;
		public int totalgrade;
		public double avg;
		List<Integer> grade = new ArrayList<>();

		public Student(String names) {
			name = names;
		}

		public void addGrade(int Grade) {
			if (Grade >= 50) {
				grade.add(Grade);
				totalgrade += Grade;
				avg = totalgrade / grade.size();
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(name + " ");
			for (int Grade : grade) {
				sb.append(Grade + " ");
			}
			sb.append((int) avg);
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
