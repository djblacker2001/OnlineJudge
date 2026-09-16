import java.util.*;
import java.io.*;

public class ProductsAverageSellingPrice_EI20213FQ1 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		Hashtable<Integer, Product> list = new Hashtable<>();

		for (int i = 0; i < n; i++) {
			int ID = reader.nextInt();
			int id = reader.nextInt();
			if (list.get(id) == null) {
				Product product = new Product(id);
				list.put(id, product);
			}
			list.get(id).Average(reader.nextInt(), reader.nextInt());
		}

		List<Product> keys = new ArrayList<>(list.values());
		keys.sort((s1, s2) -> {
			int compare = Double.compare(s2.avg, s1.avg);
			if (compare == 0) {
				compare = Integer.compare(s1.id, s2.id);
			}
			return compare;
		});

		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			outBuffer.append(keys.get(i)).append("\n");
		}
		System.out.println(outBuffer);
	}

	static class Product {
		public int id;
		public int pro;
		public double total;
		public double avg;

		public Product(int id) {
			this.id = id;
		}

		public void Average(int price, int quantity) {
			total = (double) (avg * pro + quantity * price);
			avg = (double) total / (quantity + pro);
			pro += quantity;

		}

		@Override
		public String toString() {
			StringBuilder outBuffer = new StringBuilder();
			outBuffer.append(id).append(" ").append(Math.round(avg));
			return outBuffer.toString();
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