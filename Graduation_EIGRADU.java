import java.util.*;
import java.io.*;

public class Graduation_EIGRADU {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int numberOfstudent = reader.nextInt();
		int numberOfscholarship = reader.nextInt();
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < numberOfstudent; i++) {
			String id = reader.next();
			String name = reader.next();
			Student st = new Student(id, name);
			int noCourses = reader.nextInt();
			for (int j = 0; j < noCourses; j++) {
				int score = reader.nextInt();
				st.addGrade(score);
			}
			students.add(st);
		}

		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = s1.id.compareTo(s2.id);
			}
			return compare;
		});

		int ranking = 1;
		for (int i = 0; i < students.size(); i++) {
			if (i > 0 && students.get(i).gpa < students.get(i - 1).gpa) {
				ranking = i + 1;
			}
			if (ranking <= numberOfscholarship) {
				sb.append(ranking).append(" ").append(students.get(i));
			} else {
				break;
			}
		}
		System.out.println(sb);
	}

	static class Student {
		String id;
		String name;
		int numberOfcourse = 0;
		double gpa = 0;
		double total = 0;

		public Student(String id, String name) {
			this.id = id;
			this.name = name;
		}

		void addGrade(int score) {
			if (score >= 50) {
				total += score;
				numberOfcourse++;
				gpa = total / numberOfcourse;
			}
		}

		@Override
		public String toString() {
			return id + " " + name + " " + Math.round(gpa) + "\n";
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