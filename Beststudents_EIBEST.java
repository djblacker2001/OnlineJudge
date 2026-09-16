import java.util.*;
import java.io.*;

public class Beststudents_EIBEST {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int numberOfStudent = reader.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudent; i++) {
            String name = reader.next();
            Student student = new Student(name);

            int numberOfCourse = reader.nextInt();
            for (int j = 0; j < numberOfCourse; j++) {
                student.countGPA(reader.nextInt());
            }

            students.add(student);
        }

        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.GPA, s1.GPA);
            return compare;
        });

        StringBuilder sb = new StringBuilder();
        int k = 1;

        double maxGPA = students.get(0).GPA;
        sb.append(students.get(0)).append("\n");

        while (students.get(k).GPA == maxGPA) {
            sb.append(students.get(k)).append("\n");
            k++;
            if (k == numberOfStudent) {
                break;
            }
        }

        System.out.println(sb);

    }

    static class Student {
        private String name;
        private double GPA = 0;
        private int count = 0;
        List<Integer> grade = new ArrayList<>();

        public Student(String name) {
            this.name = name;
        }

        public void countGPA(int grade) {
            if (grade >= 50) {
                count++;
                GPA = (GPA * (count - 1) + grade) / count;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(" ").append(Math.round(GPA));
            return sb.toString();

        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        char nextChar() {
            return next().charAt(0);
        }
    }
}
