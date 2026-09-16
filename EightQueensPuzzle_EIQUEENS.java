import java.util.*;
import java.io.*;

public class EightQueensPuzzle_EIQUEENS {

	public static void main(String[] args) {
		ChessBoardManager manager = new ChessBoardManager();
		int count =0;
		boolean flag = true;

		for (int y = 0; y < 8; y++) {
			boolean isChess = false;
			for (int x = 0; x < 8; x++) {
				char c = nc();
				if (c == '*' && flag) {
					Chess chess = new Chess(x, y);
					if (!manager.addChess(chess)) {
						flag = false;
						
//						System.out.println(x + " " + y+" "+c);
					}else {isChess = true;}

				}
				count++;
			}
			if(!isChess) 
			{
				manager.addChess(null);
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.print("valid");
		} else {
			System.out.print("invalid");
		}
	}

	public static class ChessBoardManager {
		Hashtable<Integer, Chess> chesses;
		ArrayList<Chess> che;

		public ChessBoardManager() {
			chesses = new Hashtable<>();
			che = new ArrayList<>();
		}

		public boolean addChess(Chess chess) {
			if(chess==null) return false;
			if (chesses.containsKey(chess.xCor)) {
				chesses.put(chess.xCor, chess);
				che.add(chess);
				return false;
			}
			if (checkPos(chess)) {
				chesses.put(chess.xCor, chess);
				che.add(chess);
			} else {
				chesses.put(chess.xCor, chess);
				che.add(chess);
				return false;
			}
			return true;
		}

		public boolean checkPos(Chess chess) {
			int pos = 1, o_pos = chess.xCor;
			for (int i = chess.yCor - 1; i >= 0; i--) {

				int posL = (o_pos - pos >= 0) ? o_pos - pos : -1;
				int posR = (o_pos + pos < 8) ? o_pos + pos : 8;
				Chess ch = che.get(i);
				if (ch.xCor == posL) {
//					System.out.println(posL + " " + i + " " + o_pos+" "+i);
//					System.out.println(ch.xCor + " " +ch.yCor);
					return false;
				}
				if (ch.xCor == posR) {
//					System.out.println(posR + " " + i + " " + o_pos);
//					System.out.println(ch.xCor + " " +ch.yCor);
					return false;

				}
				pos++;
			}

			return true;
		}
	}

	public static class Chess {
		int xCor;
		int yCor;

		public Chess(int xCor, int yCor) {
			this.xCor = xCor;
			this.yCor = yCor;
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
