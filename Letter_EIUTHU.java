import java.util.*;
import java.io.*;

public class Letter_EIUTHU {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		String a = reader.next();
		String b = reader.next();
		int leng = Math.min(a.length(), b.length());
		int count = 0;
		for (int i = 0; i <= leng; i++) {
			String c = b.substring(0, i);
			if (a.endsWith(b.substring(0, i)))
				count = c.length();
		}
		System.out.println(a.length() + b.length() - count);
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


//import java.util.*;
//import java.io.*;
//class EIUTHU {
//
//	public static void main(String[] args) {
//
//		String content1 = ns();
//		String content2 = ns();
//
//		int i = 1;
//		int max = 0;
//
//		while (i <= content1.length() && i <= content2.length()) {
//			String compare = content2.substring(0, i);
//			if (content1.endsWith(compare)) {
//				max = compare.length();
//			}
//			i++;
//		}
//
//		System.out.println(content1.length() + content2.length() - max);
//	}
//
//	static InputStream is = System.in;
//	static byte[] inbuf = new byte[1 << 24];
//	static int lenbuf = 0, ptrbuf = 0;
//
//	static int readByte() {
//		if (lenbuf == -1)
//			throw new InputMismatchException();
//		if (ptrbuf >= lenbuf) {
//			ptrbuf = 0;
//			try {
//				lenbuf = is.read(inbuf);
//			} catch (IOException e) {
//				throw new InputMismatchException();
//			}
//			if (lenbuf <= 0)
//				return -1;
//		}
//		return inbuf[ptrbuf++];
//	}
//
//	static boolean isSpaceChar(int c) {
//		return !(c >= 33 && c <= 126);
//	}
//
//	static int skip() {
//		int b;
//		while ((b = readByte()) != -1 && isSpaceChar(b))
//			;
//		return b;
//	}
//
//	static double nd() {
//		return Double.parseDouble(ns());
//	}
//
//	static char nc() {
//		return (char) skip();
//	}
//
//	static String ns() {
//		int b = skip();
//		StringBuilder sb = new StringBuilder();
//		while (!(isSpaceChar(b))) {
//			sb.appendCodePoint(b);
//			b = readByte();
//		}
//		return sb.toString();
//	}
//
//	static char[] ns(int n) {
//		char[] buf = new char[n];
//		int b = skip(), p = 0;
//		while (p < n && !(isSpaceChar(b))) {
//			buf[p++] = (char) b;
//			b = readByte();
//		}
//		return n == p ? buf : Arrays.copyOf(buf, p);
//	}
//
//	static int ni() {
//		int num = 0, b;
//		boolean minus = false;
//		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//			;
//		if (b == '-') {
//			minus = true;
//			b = readByte();
//		}
//		while (true) {
//			if (b >= '0' && b <= '9') {
//				num = num * 10 + (b - '0');
//			} else {
//				return minus ? -num : num;
//			}
//			b = readByte();
//		}
//	}
//
//	static long nl() {
//		long num = 0;
//		int b;
//		boolean minus = false;
//		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//			;
//		if (b == '-') {
//			minus = true;
//			b = readByte();
//		}
//		while (true) {
//			if (b >= '0' && b <= '9') {
//				num = num * 10 + (b - '0');
//			} else {
//				return minus ? -num : num;
//			}
//			b = readByte();
//		}
//	}
//}
//
