import java.util.*;
import java.io.*;

public class Possiblepasswords_EIUQBHV {
    static InputReader reader = new InputReader(System.in);
	public static void main(String[] args) {
		String str = reader.next();
		combineWay(str);
	}

	public static void combineWay(String arr) {
		int numSub = arr.length();
		StringBuilder bd = new StringBuilder();
		Set<String> items = new TreeSet<>();
		
		items.add(arr.substring(0,1));
		
		for(int i=1; i<arr.length(); i++) {
			Set<String> newItems = new TreeSet<>();
			for(String item : items) {
				for(int k=0; k<= item.length();k++) {
					String str = item.substring(0,k)+arr.charAt(i)+item.substring(k);
					newItems.add(str);
//					System.out.println(str);
					
				}
			}
			items=newItems;
		}
		
		List<String> list = new ArrayList<>();
		for(String str : items) {
			list.add(str);
		}

		Collections.sort(list);
		
		for(String str : list) {
			bd.append(str).append("\n");
		}
		System.out.println(list.size());
		System.out.print(bd.toString());
		
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

		public boolean hasNext() throws IOException {
			if (tokenizer != null && tokenizer.hasMoreTokens()) {
				return true;
			}
			temp = reader.readLine();
			return (temp != null && temp.length() > 0);
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
