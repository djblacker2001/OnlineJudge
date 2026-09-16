import java.util.*;
import java.io.*;

public class ArtExhibition2_EIPAINTING {

	public static void main(String[] args) {
		int numPic = ni();
		List<Integer> key = new ArrayList<>();
		Hashtable<Integer, Integer> pictures = new Hashtable<>();

		for (int i = 0; i < numPic; i++) {
			int beauty = ni();
			if (!pictures.containsKey(beauty)) {
				pictures.put(beauty, 0);
				key.add(beauty);
			}
			pictures.put(beauty, pictures.get(beauty) + 1);
		}

		key.sort(null);

		System.out.print(calJumpStep(key, pictures));
	}

	public static int calJumpStep(List<Integer> keys, Hashtable<Integer, Integer> map) {
		int count = 0;
		int empty = 0;
		while (keys.size() - empty > 1) {
			int min = map.get(findMinPic(keys, map));
			int loop = keys.size();
			count += min * (loop - empty - 1);
			for (int i = 0; i < loop; i++) {
				if (map.get(keys.get(i)) == 0)
					continue;
				int remain = map.get(keys.get(i)) - min;
				map.put(keys.get(i), remain);
				if (remain == 0) {
					empty++;
				}
			}

		}

		return count;
	}

	public static int findMinPic(List<Integer> keys, Hashtable<Integer, Integer> map) {
		int minIndex = keys.get(0);
		for (int key : keys) {
			if (map.get(key) == 0) {
				continue;
			} else {

				if (map.get(minIndex) == 0) {
					minIndex = key;
				}
				if (map.get(key) < map.get(minIndex)) {
					minIndex = key;
				}
			}
		}
		return minIndex;
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
