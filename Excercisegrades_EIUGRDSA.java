import java.util.*;
import java.io.*;

public class Excercisegrades_EIUGRDSA {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int p = reader.nextInt();
		int m = reader.nextInt();
		Hashtable<Long, Student> StuList = new Hashtable<>();
		ArrayList<Student> students = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long id = reader.nextLong();
			Student student = new Student(id);
			students.add(student);
			StuList.put(id, student);
		}

		for (int j = 0; j < p; j++) {
			long code = reader.nextLong();
			for (Student student : students) {
				student.CourseId(code);
			}
		}

		for (int k = 0; k < m; k++) {
			long id = reader.nextLong();
			long course = reader.nextLong();
			int grade = reader.nextInt();
			StuList.get(id).addGrade(course, grade);

		}

		for (Student student : students) {
			student.countAVG(p);
		}

		students.sort((s1, s2) -> {
			int compare = Long.compare(s1.id, s2.id);
			return compare;
		});

		for (Student student : students) {
			sb.append(student).append("\n");
		}
		System.out.println(sb);

	}

	static class Student {
		long id;
		int AVG = 0;
		int total = 0;
		Hashtable<Long, Integer> scores = new Hashtable<>();

		public Student(long id) {
			this.id = id;
		}

		public void CourseId(long code) {
			scores.put(code, 0);
		}

		public void addGrade(long code, int grade) {
			int a = scores.get(code);
			if (a < grade) {
				scores.replace(code, grade);
				total += (grade - a);
			}
		}

		public void countAVG(int p) {
			AVG = total / p;
		}

		@Override
		public String toString() {
			return id + " " + AVG;
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

		public boolean hasNext() throws IOException {
			if (tokenizer != null && tokenizer.hasMoreTokens()) {
				return true;
			}
			temp = reader.readLine();
			return (temp != null && temp.length() > 0);
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