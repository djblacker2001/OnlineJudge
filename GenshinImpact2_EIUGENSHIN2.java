import java.math.*;
import java.io.*;
import java.util.*;

public class GenshinImpact2_EIUGENSHIN2 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();        // số lượt tấn công
        int m = in.nextInt();        // số nhân vật
        int k = in.nextInt();        // top K

        // Bảng hệ số phản ứng nguyên tố
        Map<Set<String>, Double> reactionCoeff = new HashMap<>();
        reactionCoeff.put(new HashSet<>(Arrays.asList("Pyro","Hydro")),       1.0);
        reactionCoeff.put(new HashSet<>(Arrays.asList("Pyro","Cryo")),        0.5);
        reactionCoeff.put(new HashSet<>(Arrays.asList("Pyro","Electro")),     0.3);
        reactionCoeff.put(new HashSet<>(Arrays.asList("Hydro","Cryo")),       0.2);
        reactionCoeff.put(new HashSet<>(Arrays.asList("Hydro","Electro")),    0.3);
        reactionCoeff.put(new HashSet<>(Arrays.asList("Cryo","Electro")),     0.3);

        // Đọc thông tin nhân vật
        Map<String, Character> chars = new HashMap<>(m);
        for (int i = 0; i < m; i++) {
            String name    = in.next();
            long ad        = in.nextLong();
            long cd        = in.nextLong();
            String element = in.next();
            chars.put(name, new Character(name, ad, cd, element));
        }

        String bossElement = null;
        // Xử lý các lượt tấn công
        for (int i = 0; i < n; i++) {
            String name     = in.next();
            int isCrit      = in.nextInt();
            Character c     = chars.get(name);
            String elem     = c.element;

            double coeff = 0.0;
            if (bossElement != null && !bossElement.equals(elem)) {
                // Có phản ứng với hệ số tương ứng
                Set<String> key = new HashSet<>(Arrays.asList(bossElement, elem));
                coeff = reactionCoeff.getOrDefault(key, 0.0);
                // Sau phản ứng, boss mất hết nguyên tố
                bossElement = null;
            } else {
                // Không phản ứng, hoặc cùng nguyên tố → gán nguyên tố mới
                bossElement = elem;
            }

            long base = (isCrit == 1 ? c.cd : c.ad);
            // Tính sát thương của lượt này
            double damage = base * (1 + coeff);
            c.totalDamage += damage;
        }

        // Chuẩn bị danh sách để sort
        List<Character> list = new ArrayList<>(chars.values());
        // Sắp xếp: giảm dần theo totalDamage, rồi tăng dần theo name
        list.sort((c1, c2) -> {
            int cmp = Double.compare(c2.totalDamage, c1.totalDamage);
            if (cmp == 0) {
                return c1.name.compareTo(c2.name);
            }
            return cmp;
        });

        // Xác định ngưỡng lấy top K (kể cả những ai bằng K)
        long cutoff = javaRound(list.get(k-1).totalDamage);

        // In kết quả
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            long rounded = javaRound(c.totalDamage);
            if (rounded < cutoff) break;
            sb.append(c.name).append(" ").append(rounded).append("\n");
        }
        System.out.print(sb);
    }

    // Làm tròn giống Math.round(double) của Java (ROUND_HALF_UP)
    private static long javaRound(double x) {
        return new BigDecimal(x).setScale(0, RoundingMode.HALF_UP).longValueExact();
    }

    static class Character {
        String name;
        long ad, cd;
        String element;
        double totalDamage;

        Character(String name, long ad, long cd, String element) {
            this.name = name;
            this.ad = ad;
            this.cd = cd;
            this.element = element;
            this.totalDamage = 0;
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
