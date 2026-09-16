import java.util.*;
import java.io.*;

public class STOCKMARKET_EISHARE {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int transactions = reader.nextInt();
		int topHighestProfit = reader.nextInt();
		Hashtable<String, StockShare> map = new Hashtable<>();

		for (int i = 0; i < transactions; i++) {
			char typeOfTransaction = reader.nextChar();
			String StockShare = reader.next();
			StockShare stockShare = new StockShare(StockShare);

			if (typeOfTransaction == 'B') {
				if (map.get(StockShare) == null) {
					int quantity = reader.nextInt();
					long price = reader.nextLong();
					stockShare.buyStockShare(quantity, price);
					map.put(StockShare, stockShare);
				} else {
					map.get(StockShare).buyStockShare(reader.nextInt(), reader.nextLong());
				}
			} else {
				map.get(StockShare).sellStockShare(reader.nextInt(), reader.nextLong());
			}

		}

		List<StockShare> list = new ArrayList<>(map.values());
		list.sort((s1, s2) -> {
			int compare = Double.compare(s2.profit, s1.profit);
			if (compare == 0) {
				compare = s1.name.compareTo(s2.name);
			}
			return compare;
		});
		showList(list, topHighestProfit);

	}

	public static void showList(List<StockShare> list, int topProfitable) {
		if (topProfitable >= list.size()) {
			for (StockShare stockShare : list) {
				sb.append(stockShare).append("\n");
			}
		} else {
			double check = list.get(topProfitable).profit;
			for (StockShare stockShare : list) {
				if (stockShare.profit == check) {
					break;
				}
				sb.append(stockShare).append("\n");
			}
		}
		System.out.println(sb);

	}

	static class StockShare {
		String name;
		double profit;

		public StockShare(String name) {
			this.name = name;
		}

		public void buyStockShare(int quantity, long price) {
			profit -= quantity * price * 1.001;
		}

		public void sellStockShare(int quantity, long price) {
			profit += quantity * price * 0.998;
		}

		@Override
		public String toString() {
			return name + " " + Math.round(profit);
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