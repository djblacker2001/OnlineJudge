import java.util.*;
import java.io.*;

public class Thehighestprofitableproduct_EIHPROFIT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();
		ArrayList<Product> products = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			String nameOfproduct = reader.next();
			int price = reader.nextInt();
			int cost = reader.nextInt();
			int quantity = reader.nextInt();
			Product product = new Product(id, nameOfproduct);
			product.getProfit(quantity, cost, price);
			products.add(product);
		}
		products.sort((s1, s2) -> {
			int compare = Double.compare(s2.profit, s1.profit);
			if (compare == 0) {
				compare = s1.id - s2.id;
			}
			return compare;
		});

		if (k < products.size()) {
			int i = 0;
			for (; i < k; i++) {
				sb.append(products.get(i));
			}
			i--;
			while (products.get(i + 1).profit == products.get(i).profit) {
				sb.append(products.get(i + 1));
				i++;
			}
		} else {
			for (Product product : products) {
				sb.append(product);
			}
		}
		System.out.println(sb);
	}

	static class Product {
		int id;
		String name;
		long profit;

		public Product(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public void getProfit(int quantity, int cost, int price) {
			profit = (long) quantity * (price - cost);
		}

		@Override
		public String toString() {
			return id + " " + name + " " + profit + "\n";
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

		char nextChar() {
			return next().charAt(0);
		}
	}
}
