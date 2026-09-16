import java.util.*;
import java.io.*;

public class Warehousemanagement_EISTOCK2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        Hashtable<Integer, Stock> stocks = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            if (reader.nextChar() == '+') {
                int id = reader.nextInt();
                int quantity = reader.nextInt();
                int price = reader.nextInt();
                int time = reader.nextInt();
                if (stocks.get(id) == null) {
                    Stock stock = new Stock(quantity, price, time);
                    stocks.put(id, stock);
                } else {
                    stocks.get(id).Import(quantity, price, time);
                }

            } else {
                int id = reader.nextInt();
                int quantity = reader.nextInt();
                int price = reader.nextInt();
                int time = reader.nextInt();

                if (stocks.get(id) != null) {
                    if (quantity != stocks.get(id).storage) {
                        stocks.get(id).Export(quantity);
                    } else {
                        stocks.remove(id);
                    }
                }
            }
        }
        List<Integer> keysets = new ArrayList<>(stocks.keySet());
        keysets.sort(null);

        for (Integer key : keysets) {
            sb.append(key).append(" ").append(stocks.get(key)).append("\n");
        }

        System.out.println(sb);

    }

    static class Stock {
        public int storage;
        public double avgPrice;
        ArrayDeque<Transaction> transactions = new ArrayDeque<>();

        public Stock(int quantity, int price, int time) {
            storage += quantity;
            Transaction transaction = new Transaction(quantity, price, time);
            transactions.add(transaction);

        }

        public void Import(int quantity, int price, int time) {
            storage += quantity;
            Transaction transaction = new Transaction(quantity, price, time);
            transactions.add(transaction);

        }

        public void Export(int quantity) {
            if (quantity <= storage) {
                storage -= quantity;
                Transaction head = transactions.poll();

                while (quantity > head.quantity) {
                    quantity -= head.quantity;
                    head = transactions.poll();
                }

                if (quantity < head.quantity) {
                    head.replace(quantity);
                    transactions.addFirst(head);
                }

            }
        }

        public void avg() {
            long total = 0;
            ArrayDeque<Transaction> b = transactions.clone();
            for (Transaction a : b) {
                total += b.poll().totalPrice;
            }
            avgPrice = (double) total / storage;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            avg();
            sb.append(storage).append(" ").append((int) avgPrice).append(" ").append(transactions.peek().time);
            return sb.toString();
        }

    }

    static class Transaction {
        public int quantity;
        public int time;
        public int price;
        public long totalPrice;

        public Transaction(int quantity, int price, int time) {
            this.quantity = quantity;
            this.price = price;
            this.time = time;
            totalPrice = (long) price * quantity;
        }
        public void replace(int quantity) {
            this.quantity -= quantity;
            totalPrice = (long) this.quantity * price;
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