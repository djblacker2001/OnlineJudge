import java.util.*;
import java.io.*;

public class Pagenumbers_EIPAGES {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);

        // Bước 3: Duyệt qua mảng và xử lý các khoảng
        for (int i = 0; i < n; i++) {
            int start = i; // Bắt đầu khoảng liên tiếp
            int end = i + 1; // Điểm kiểm tra số tiếp theo

            // Kiểm tra các số liên tiếp
            while (end < n && arr[end] == arr[start] + 1) {
                start++; // Cập nhật vị trí kết thúc khoảng
                end++;
            }

            // Lưu kết quả của khoảng vừa tìm được
            if (start - i > 1) {                                 // Khoảng có hơn 2 số
                sb.append(arr[i]).append("-").append(arr[start]);
            } else if (start - i == 1) {                         // Khoảng có đúng 2 số
                sb.append(arr[i]).append(" ").append(arr[start]);
            } else {                                             // Khoảng chỉ có 1 số
                sb.append(arr[i]);
            }

            i = start;
            if (start < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}