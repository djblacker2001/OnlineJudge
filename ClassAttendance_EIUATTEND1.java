import java.util.*;
import java.io.*;

public class ClassAttendance_EIUATTEND1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		Hashtable<Long, Student> studentList = new Hashtable<>();
		Hashtable<Long, Class> classList = new Hashtable<>();
		long tempTimeStart = -1;
		for (int i = 0; i < n; i++) {
			long timeStart = reader.nextLong();
			long studentID = reader.nextLong();
			long classID = reader.nextLong();
			int check = reader.nextInt();

			if (studentList.get(studentID) == null) {
				Student student = new Student(studentID);
				student.addClass(classID, check);
				studentList.put(studentID, student);

			} else {
				studentList.get(studentID).addClass(classID, check);
				;
			}

			if (classList.get(classID) == null) {
				Class newClass = new Class(classID);
				newClass.countLesson();
				classList.put(classID, newClass);
			} else if (tempTimeStart != timeStart) {
				classList.get(classID).countLesson();
			}

			tempTimeStart = timeStart;

		}
		List<Long> numOfClassLesson = new ArrayList<>(classList.keySet());
		List<Student> list = new ArrayList<>(studentList.values());
		for (Student stu : list) {
			for (Long id : numOfClassLesson) {
				stu.Attendance(id, classList.get(id).total);
			}
		}

		list.sort((s1, s2) -> {
			int compare = Long.compare(s1.ID, s2.ID);
			return compare;
		});

		for (Student stu : list) {
			sb.append(stu).append("\n");
		}

		System.out.println(sb);
	}

	static class Class {
		public long ID;
		public int total;
		public int numberOfStudent;
		public Hashtable<Long, Integer> stuList;

		public Class(long ID) {
			this.ID = ID;
			stuList = new Hashtable<>();
		}

		public void countLesson() {
			total++;
		}

		public void addStudent(long idStudent) {
			stuList.put(idStudent, 1);
		}
	}

	static class Student {
		private long ID;
		public int absence;
		public int present;
		public int totalLesson;

		private Hashtable<Long, Integer> classAttendance;

		public Student(Long ID) {
			this.ID = ID;
			classAttendance = new Hashtable<>();

		}

		public void addClass(long IDClass, int check) {
			if (classAttendance.get(IDClass) == null) {
				classAttendance.put(IDClass, 1);
				Present(check);
			} else {
				classAttendance.put(IDClass, classAttendance.get(IDClass) + 1);
				Present(check);
			}
		}

		public void Present(int check) {
			if (check == 1) {
				present++;
			} else {
				absence++;
			}
			totalLesson++;
		}

		public void Attendance(long IDClass, int lesson) {
			long ID = IDClass;
			if (classAttendance.get(IDClass) != lesson) {
				long a = ID;
				long b = lesson;
				int c = classAttendance.get(IDClass);

				absence += lesson - classAttendance.get(IDClass);
				classAttendance.put(IDClass, lesson);

			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(ID).append(" ").append(absence).append(" ").append(present);
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