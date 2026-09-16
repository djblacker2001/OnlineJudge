import java.util.*;
import java.io.*;

public class Phancongcongviec_EITASKDIS {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			arr.add(reader.nextInt());
		}
		arr.sort((p1,p2) ->p2-p1);
		
		PriorityQueue<Person> workers = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            workers.add(new Person(i, 0));
        }
        for (int job : arr) {
        	 Person worker = workers.poll();
             worker.time += job; 
             workers.add(worker);
        }
        int[] result = new int[n];
        while (!workers.isEmpty()) {
            Person worker = workers.poll();
            result[worker.index] = worker.time;
        }
  
        for (int time : result) {
            System.out.print(time + " ");
        }
		
	}

	static  class Person implements Comparable<Person> {
        int index; 
        int time;
        Person(int index, int time) {
            this.index = index;
            this.time = time;
        }
        
        @Override
        public int compareTo(Person other) {
            if (this.time == other.time) {
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.time, other.time);
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
