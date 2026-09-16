import java.util.*;
import java.io.*;

public class StockManagement_EISTOCK {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        TreeMap<Long, Stock> inventory = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            char x = reader.nextChar();
            long code = reader.nextLong();
            int quantity = reader.nextInt();
            long price = reader.nextLong();

            if (x == '+') {
                inventory.putIfAbsent(code, new Stock(0, 0));
                inventory.get(code).importI(quantity, price);
            } else if (x == '-') {
                if (inventory.containsKey(code) && inventory.get(code).Storage >= quantity) {
                    inventory.get(code).deportI(quantity, price);
                }
            }
        }

        for (Map.Entry<Long, Stock> entry : inventory.entrySet()) {
            sb.append(entry.getKey()).append(" ")
                    .append(entry.getValue().importValue).append(" ")
                    .append(entry.getValue().deportValue).append("\n");
        }
        System.out.println(sb);
    }

    static class Stock {
        public int Storage;
        public long importValue;
        public long deportValue;

        public Stock(int quantity, long price) {
            Storage = quantity;
            importValue = quantity * price;
            deportValue = 0;
        }

        public void importI(int quantity, long price) {
            importValue += quantity * price;
            Storage += quantity;
        }

        public void deportI(int quantity, long price) {
            deportValue += quantity * price;
            Storage -= quantity;
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        char nextChar() {
            return next().charAt(0);
        }
    }
}
