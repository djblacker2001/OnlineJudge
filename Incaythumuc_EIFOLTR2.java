import java.util.*;
import java.io.*;

public class Incaythumuc_EIFOLTR2 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        HashMap<String, Vertex> adj = new HashMap<>();
        int n = ni();
        for (int i = 0; i < n - 1; i++) {
            String u = ns();
            String v = ns();

            adj.putIfAbsent(u, new Vertex(u));
            adj.putIfAbsent(v, new Vertex(v));

            adj.get(v).addVertex(adj.get(u));
            adj.get(u).addVertex(adj.get(v));
        }

        for (Vertex v : adj.values()) {
            v.adjacent.sort((s1, s2) -> s1.id.compareToIgnoreCase(s2.id));
        }

        String root = ns();
        adj.get(root).visited = true;
        sb.append(root).append('\n');

        List<Vertex> children = adj.get(root).adjacent;
        for (int i = 0; i < children.size(); i++) {
            dfs(children.get(i), "", i == children.size() - 1);
        }

        System.out.print(sb);
    }

    static void dfs(Vertex u, String prefix, boolean isLast) {
        sb.append(prefix);
        if (isLast)
            sb.append("└───");
        else
            sb.append("├───");
        sb.append(u.id).append('\n');

        u.visited = true;

        List<Vertex> children = new ArrayList<>();
        for (Vertex v : u.adjacent) {
            if (!v.visited)
                children.add(v);
        }

        for (int i = 0; i < children.size(); i++) {
            String newPrefix = prefix + (isLast ? "    " : "│   ");
            dfs(children.get(i), newPrefix, i == children.size() - 1);
        }
    }

    static class Vertex {
        String id;
        boolean visited = false;
        List<Vertex> adjacent = new ArrayList<>();

        public Vertex(String id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
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