import java.util.*;
import java.io.*;

public class Scholarships_EIUSLS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int studentss = reader.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < studentss; i++) {
			Student student = new Student(reader.next());
			int numberOfCourse = reader.nextInt();

			for (int j = 0; j < numberOfCourse; j++) {
				student.GPA(reader.nextInt());
			}
			students.add(student);
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.GPA, s1.GPA);
			return compare;
		});

		int i = 0;
		while (i < 2 && i < students.size()) {
			sb.append(students.get(i).name).append("\n");
			i++;
		}
		System.out.println(sb);
	}

	static class Student {
		private String name;
		private double GPA = 0;
		private int count = 0;

		public Student(String name) {
			this.name = name;
		}

		public void GPA(int grade) {
			count++;
			GPA = (GPA * (count - 1) + grade) / count;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(name);
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