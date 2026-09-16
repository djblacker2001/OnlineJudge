import java.util.*;
import java.io.*;

public class Installmentpurchase_EIINPUR {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        double originalDebt = reader.nextDouble();
        double monthlyPay = reader.nextDouble();
        int noMonth = reader.nextInt();
        int k = reader.nextInt();

        double lowRate = 0, highRate = 1;
        double rate = findRate(originalDebt, monthlyPay, highRate, lowRate, noMonth);
        double debt = checkDebt(originalDebt, monthlyPay, rate, k-1);
        debt *=(1+rate);
        
        System.out.println(Math.round(debt));

    }

    static double findRate(double originalDebt, double monthlyPay, double highRate, double lowRate, int month) {
        double mid = (highRate + lowRate) / 2;
        double debt;

        while (highRate - lowRate > 0.0000000001) {
            double a = highRate - lowRate;
            mid = (highRate + lowRate) / 2;
            
            debt = checkDebt(originalDebt, monthlyPay, mid, month);
            if (debt > 0) {
                highRate = mid;
            } else if(debt < 0){
                lowRate = mid;
            }else {
                return mid;
            }
        }
        return lowRate;
    }

    static double checkDebt(double originalDebt, double monthlyPay, double rate, int month) {
        double debt = originalDebt;
        for (int i = 0; i < month; i++) {
            debt = debt * (1 + rate) - monthlyPay;
        }
        return debt;
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
