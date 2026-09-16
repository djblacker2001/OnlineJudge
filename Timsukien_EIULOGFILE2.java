import java.util.*;
import java.io.*;

public class Timsukien_EIULOGFILE2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int numberOfLogfile = reader.nextInt();
		int numberOfEvent = reader.nextInt();

		List<Long> listLogfiles = new ArrayList<>();
		List<Integer> listResultIndex = new ArrayList<>();

		for (int i = 0; i < numberOfLogfile; i++) {
			long logfile = reader.nextLong();
			listLogfiles.add(logfile);
		}
		listLogfiles.sort(null);

		for (int j = 0; j < numberOfEvent; j++) {
			long event = reader.nextLong();
			listResultIndex.add(findEvent(listLogfiles, event));
		}
		for (int k = 0; k < listResultIndex.size(); k++) {
			int index = listResultIndex.get(k);
			if (index < listLogfiles.size()) {
				sb.append(listLogfiles.get(index)).append(" ");
			} else {
				sb.append(-1).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static Integer findEvent(List<Long> list, long event) {
		int resultIndex = list.size();

		resultIndex = Collections.binarySearch(list, event);
		if (resultIndex < 0) {
			resultIndex = ~resultIndex;
		}
		return resultIndex;
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
