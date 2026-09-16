import java.util.*;
import java.io.*;

public class SCHOLARSHIPS_EISCH4 {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int numberOfStudent = reader.nextInt();
        int numberOfShoolarship = reader.nextInt();
        int creditRequire = reader.nextInt();
        int GPARequire = reader.nextInt();
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < numberOfStudent; i++) {
            String name = reader.next();
            Student student = new Student(name);
            int numberOfCourse = reader.nextInt();

            for (int j = 0; j < numberOfCourse; j++) {
                student.addGrade(reader.nextInt());
            }
            student.calculateGPA();
            list.add(student);

        }

        list.sort((s1, s2) -> {
            int compare = Integer.compare(s2.credit, s1.credit);
            if (compare == 0) {
                compare = Double.compare(s2.GPA, s1.GPA);
            }
            return compare;
        });

        List<Student> listOfStudentReachRequire = checkCondition(list, creditRequire, GPARequire);
        listOfStudentReachRequire.sort((s1, s2) -> {
            int compare = Double.compare(s2.GPA, s1.GPA);
            if (compare == 0) {
                compare = s1.name.compareTo(s2.name);
            }
            return compare;
        });

        StringBuilder sb = new StringBuilder();
        if (numberOfShoolarship < listOfStudentReachRequire.size()) {
            double check = listOfStudentReachRequire.get(numberOfShoolarship).GPA;

            for (int i = 0; i < listOfStudentReachRequire.size(); i++) {
                double GPA = listOfStudentReachRequire.get(i).GPA;
                if (GPA == check) {
                    break;
                }
                sb.append(listOfStudentReachRequire.get(i)).append("\n");
            }
        }else {
            for (int i = 0; i < listOfStudentReachRequire.size(); i++) {
    
                sb.append(listOfStudentReachRequire.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static List<Student> checkCondition(List<Student> list, int creditRequire, int GPARequire) {
        List<Student> temp = new ArrayList<>();
        for (Student student : list) {
            if (student.credit < creditRequire && student.GPA < GPARequire) {
                break;
            }
            if (student.credit >= creditRequire && student.GPA >= GPARequire) {
                temp.add(student);
            }

        }
        return temp;

    }

    static class Student {
        private String name;
        private int credit = 0;
        private double GPA = 0;
        private int count = 0;
        private double total;

        public Student(String name) {
            this.name = name;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                count++;
                credit += 4;
                total +=grade;
            }
        }

        public int getCredit() {
            return credit;
        }

        public void calculateGPA() {
            if(count>0) {
            GPA = total/count;
            }
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(" ").append(GPA);
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