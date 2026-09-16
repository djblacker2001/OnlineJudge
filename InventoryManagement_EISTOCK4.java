import java.io.*;
import java.util.*;

public class InventoryManagement_EISTOCK4 {
    static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

    static class Batch {
        long qty;
        long price;
        long time;
        Batch(long qty, long price, long time) {
            this.qty = qty;
            this.price = price;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = reader.nextInt();

        // Map: product code → queue of batches
        Map<Long, Deque<Batch>> products = new HashMap<>();
        // Track total quantity of each product
        Map<Long, Long> total = new HashMap<>();
        // Track seen product codes for sorting at the end
        Set<Long> seen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.next());
            char sign = st.nextToken().charAt(0);
            long Ci = Long.parseLong(st.nextToken());
            long Qi = Long.parseLong(st.nextToken());
            long Pi = Long.parseLong(st.nextToken());
            long Ti = Long.parseLong(st.nextToken());

            seen.add(Ci);

            if (sign == '+') {
                products.computeIfAbsent(Ci, k -> new ArrayDeque<>()).addLast(new Batch(Qi, Pi, Ti));
                total.put(Ci, total.getOrDefault(Ci, 0L) + Qi);

            } else if (sign == '-') {
                long currentTotal = total.getOrDefault(Ci, 0L);
                if (currentTotal < Qi) {
                    // Not enough stock, skip
                    continue;
                }

                Deque<Batch> queue = products.get(Ci);
                long remaining = Qi;

                while (remaining > 0 && !queue.isEmpty()) {
                    Batch first = queue.peekFirst();
                    if (first.qty > remaining) {
                        first.qty -= remaining;
                        total.put(Ci, currentTotal - Qi);
                        remaining = 0;
                    } else {
                        remaining -= first.qty;
                        queue.pollFirst();
                    }
                }

                total.put(Ci, total.get(Ci) - Qi);
            }
        }

        // Prepare sorted list of product codes
        List<Long> sortedCodes = new ArrayList<>(seen);
        Collections.sort(sortedCodes);

        // Output remaining products
        for (long code : sortedCodes) {
            Deque<Batch> q = products.get(code);
            if (q == null) continue;
            for (Batch b : q) {
                if (b.qty > 0) {
                    long value = b.qty * b.price;
                    bw.write(code + " " + value + " " + b.time + "\n");
                }
            }
        }

        bw.flush();
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
