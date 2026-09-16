import java.util.*;
import java.io.*;

public class Tinhdiemmonhoc_EIUGRDSA2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int p = reader.nextInt();
		int m = reader.nextInt();
		Hashtable<Long, Student> tab = new Hashtable<>();
		List<Student> stu = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			long id = reader.nextLong();
			Student student = new Student(id);
			stu.add(student);
			tab.put(id, student);
		}

		for (int j = 0; j < p; j++) {
			long code = reader.nextLong();
			for (Student student : stu) {
				student.CourseId(code);
			}
		}

		for (int k = 0; k < m; k++) {
			long id = reader.nextLong();
			long code = reader.nextInt();
			int grade = reader.nextInt();
			tab.get(id).addGrade(code, grade);
		}
		for (Student student : stu) {
			student.countAVG(p);

		}
		stu.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = Integer.compare(s1.handin, s2.handin);
				if (compare == 0) {
					compare = Long.compare(s1.id, s2.id);
				}
			}
			return compare;
		});

		for (Student student : stu) {
			sb.append(student);
		}

		System.out.println(sb);

	}

	static class Student {
		long id;
		int total = 0;
		int gpa = 0;
		int handin = 0;
		Hashtable<Long, Integer> scores = new Hashtable<>();

		public Student(long id) {
			this.id = id;
		}

		public void CourseId(long code) {
			scores.put(code, 0);
		}

		public void addGrade(long code, int grade) {
			if (scores.get(code) != null) {
				handin++;
				int a = scores.get(code);
				if (a < grade) {
					total += (grade - a);
					scores.replace(code, grade);
				}
			}
		}

		public void countAVG(int p) {
			gpa = total / p;
		}

		@Override
		public String toString() {
			return id + " " + gpa + " " + handin + "\n";
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
