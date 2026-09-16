import java.io.*;
import java.util.*;

public class Samebirthday_EIDUPBOD {

    public static void main(String[] args) {
        int n = ni();
        Hashtable<Student, Integer> counts = new Hashtable<>();
        for (int i = 0; i < n; i++) {
        	Student date = new Student(ni(), ni(), ni());
            Integer count = counts.get(date);
            if (count == null) {
                counts.put(date, 1);
            } else if (counts.containsKey(date)) {
                counts.replace(date, count + 1);
            }
        }

        ArrayList<Student> list = new ArrayList<>(counts.keySet());
        list.sort((s1, s2) -> {
            int compare = Integer.compare(s1.year, s2.year);
            if (compare == 0) {
                compare = Long.compare(s1.month, s2.month);
                if (compare == 0) {
                    compare = Long.compare(s1.day, s2.day);
                }
            }
            return compare;
        });

        for(int j =0; j< list.size(); j++) {
            System.out.println(list.get(j).toString() + " " + counts.get(list.get(j)));
        }
        
    }

    static class Student {
        public int day;
        public int month;
        public int year;

        public Student(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (day < 10) {
                sb.append("0").append(day);

            } else {
                sb.append(day);
            }

            if (month < 10) {
                sb.append("/0").append(month);
            } else {
                sb.append("/").append(month);
            }

            sb.append("/").append(year);
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student birthday = (Student) o;
            return Objects.equals(day, birthday.day) && Objects.equals(month, birthday.month)
                    && Objects.equals(year, birthday.year);
        }

        @Override
        public int hashCode() {
            return Objects.hash(day, month, year);
        }

    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
