import java.util.*;
import java.io.*;

public class Incaythumuc_EIFOLTRE {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Hashtable<String, Vertex> vertices = new Hashtable<>();
        int n = reader.nextInt();

        for (int i = 0; i < n - 1; i++) {
            String uN = reader.next();
			String vN = reader.next();

            if (vertices.get(vN) == null) {
                vertices.put(vN, new Vertex(vN));
            }
            if (vertices.get(uN) == null) {
                vertices.put(uN, new Vertex(uN));
            }

            vertices.get(vN).addVertex(vertices.get(uN));
            vertices.get(uN).addVertex(vertices.get(vN));

        }

        List<String> keys = new ArrayList<>(vertices.keySet());
        for (int i = 0; i < keys.size(); i++) {
            vertices.get(keys.get(i)).adjacentVertices.sort((v1, v2) -> v1.id.compareToIgnoreCase(v2.id));
        }

        String root = reader.next();
        int step = 0;

        vertices.get(root).setVisited(true);
        sb.append(drawMap(step, vertices.get(root)));

        System.out.println(sb);
    }

    static String drawMap(int step, Vertex branch) {
        StringBuilder sb = new StringBuilder();

        sb.append("-");
        for (int i = 0; i < step; i++) {
            sb.append("---");
        }
        sb.append(branch.id).append("\n");

        for (int i = 0; i < branch.adjacentVertices.size(); i++) {
            Vertex branch1 = branch.adjacentVertices.get(i);

            if (branch1.visited == false) {
                branch1.setVisited(true);
                sb.append(drawMap(step + 1, branch1));
            }
        }

        return sb.toString();
    }

    static int dfs(Vertex vertex) {
        int count = 1;
        for (Vertex next : vertex.adjacentVertices) {
            if (!next.visited) {
                next.visited = true;
                count += dfs(next);
            }
        }
        return count;
    }

    

    static class Vertex {
        public String id;
        public boolean visited = false;
        public List<Vertex> adjacentVertices = new ArrayList<Vertex>();
 
        public Vertex(String id) {
            this.id = id;
        }
 
        public void setVisited(boolean flag) {
            this.visited = flag;
        }
 
        public void addVertex(Vertex vertex) {
            boolean flag = false;
            for (int i = 0; i < adjacentVertices.size(); i++) {
                if (adjacentVertices.get(i).id.equals(vertex.id)) {
                    flag = true;
                }
            }
            if (!flag) {
                adjacentVertices.add(vertex);
            }
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

		public char nextChar() {
			return next().charAt(0);
		}
	}
}