import java.util.*;
import java.io.*;

public class LinkedList_EILINKED {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        if (n > 0) sc.nextLine();

        List<String> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "sum":
                    results.add(String.valueOf(list.stream().mapToInt(Integer::intValue).sum()));
                    break;

                case "average":
                    results.add(list.isEmpty() ? "0" : String.valueOf(list.stream().mapToInt(Integer::intValue).average().orElse(0)));
                    break;

                case "getAt":
                    int index = Integer.parseInt(parts[1]);
                    if (index >= 0 && index < list.size()) {
                        results.add(String.valueOf(list.get(index)));
                    } else {
                        results.add("Error");
                    }
                    break;

                case "size":
                    results.add(String.valueOf(list.size()));
                    break;

                case "firstIndexOf":
                    int value = Integer.parseInt(parts[1]);
                    results.add(String.valueOf(list.indexOf(value)));
                    break;

                case "lastIndexOf":
                    value = Integer.parseInt(parts[1]);
                    results.add(String.valueOf(list.lastIndexOf(value)));
                    break;

                case "add":
                    value = Integer.parseInt(parts[1]);
                    list.add(value);
                    break;

                case "remove":
                    value = Integer.parseInt(parts[1]);
                    list.remove(Integer.valueOf(value));
                    break;
            }
        }

        for (String res : results) {
            System.out.println(res);
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
