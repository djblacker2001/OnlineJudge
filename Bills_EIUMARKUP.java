import java.util.*;
import java.io.*;

public class Bills_EIUMARKUP {
	static InputReader reader = new InputReader(System.in);
	public static void main(String[] args) {
		long n = reader.nextLong();
		if(n<=100)
			System.out.print(n*200);
		else if(n<=200)
			System.out.print(100*200+(n-100)*199);
		else if(n<=300)
			System.out.print(20000+19900+(n-200)*198);
		else if(n<=400)
			System.out.print(20000+19900+19800+(n-300)*197);
		else if(n<=500)
			System.out.print(20000+19900+19800+19700+(n-400)*196);
		else if(n<=600)
			System.out.print(20000+19900+19800+19700+19600+(n-500)*195);
		else if(n<=700)
			System.out.print(20000+19900+19800+19700+19600+19500+(n-600)*194);
		else if(n<=800)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+(n-700)*193);
		else if(n<=900)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+(n-800)*192);
		else if(n<=1000)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+(n-900)*191);
		else if(n<=1100)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+(n-1000)*190);
		else if(n<=1200)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+(n-1100)*189);
		else if(n<=1300)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+(n-1200)*188);
		else if(n<=1400)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+(n-1300)*187);
		else if(n<=1500)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+(n-1400)*186);
		else if(n<=1600)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+18600+(n-1500)*185);
		else if(n<=1700)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+18600+18500+(n-1600)*184);
		else if(n<=1800)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+18600+18500+18400+(n-1700)*183);
		else if(n<=1900)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+18600+18500+18400+18300+(n-1800)*182);
		else if(n<=2000)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+18600+18500+18400+18300+18200+(n-1900)*181);
		else if(n>2000)
			System.out.print(20000+19900+19800+19700+19600+19500+19400+19300+19200+19100+19000+18900+18800+18700+18600+18500+18400+18300+18200+18100+(n-2000)*180);
		
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

