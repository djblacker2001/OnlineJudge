import java.util.*;
import java.io.*;

public class GenshinImpact_EIUGENSHIN {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt(); // số lượng hành động
        int m = reader.nextInt(); // số lượng nhân vật/

        Hashtable<String, Character> characters = new Hashtable<>();
        for (int i = 0; i < m; i++) {
            String name = reader.next();
            int ad = reader.nextInt();
            int cd = reader.nextInt();
            Character character = new Character(name, ad, cd);
            characters.put(name, character);
        }

        for (int i = 0; i < n; i++) {
            String name = reader.next();
            int hit = reader.nextInt();
            Character c = characters.get(name);
            if (c != null) {
                c.performHit(hit);
            }
        }

        List<Character> keys = new ArrayList<>(characters.values());
        keys.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg); // sắp xếp giảm dần theo avg
            if (compare == 0) {
                compare = s1.name.compareTo(s2.name); // nếu bằng nhau thì so tên tăng dần
            }
            return compare;
        });

        StringBuilder outBuffer = new StringBuilder();
        for (Character character : keys) {
            outBuffer.append(character).append("\n");
        }
        System.out.print(outBuffer);
    }

    static class Character {
        public String name;
        public int ad;
        public int cd;
        public long total;
        public double avg;
        public long count;

        public Character(String name, int ad, int cd) {
            this.name = name;
            this.ad = ad;
            this.cd = cd;
            this.total = 0;
            this.count = 0;
            this.avg = 0;
        }

        public void performHit(int hit) {
            if (hit == 0) {
                total += ad;
            } else {
                total += cd;
            }
            count++;
            avg = (double) total / count;
        }

        @Override
        public String toString() {
            if (count == 0) {
                return name + " 0";
            } else {
                return name + " " + Math.round(avg);
            }
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
