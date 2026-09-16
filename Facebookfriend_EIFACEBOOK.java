import java.util.*;
import java.io.*;

public class Facebookfriend_EIFACEBOOK {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        Vertex ver[] = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            ver[i] = new Vertex(i);
        }

        for (int i = 1; i <= n; i++) {
            String gender = reader.next();
            if (gender.equals("Nam")) {
                ver[i].isMale = true;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            if (ver[u].isMale != ver[v].isMale) {
                ver[u].addVertex(ver[v]);
                ver[v].addVertex(ver[u]);
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(ver[i].adjacent.size()).append(" ");
        }

        System.out.println(sb);
    }

    static class Vertex {
        int id;
        boolean isMale = false;
        HashSet <Vertex> adjacent = new HashSet<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addVertex(Vertex v) {
            adjacent.add(v);
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