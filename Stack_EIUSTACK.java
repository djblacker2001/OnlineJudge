import java.util.*;
import java.io.*;

public class Stack_EIUSTACK<T extends Number> {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();
        Stack_EIUSTACK<Integer> stack = new Stack_EIUSTACK<Integer>(n);
        // You code here
        
        for (int i = 0; i < m; i++) {
            int number = reader.nextInt();
            stack.push(number);
        }
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            String queue = reader.next();
            if (queue.equals("push")) {
                stack.push(reader.nextInt());
            } else {
                if (queue.equals("peek")) {
                    sb.append(stack.peek());
                } else if (queue.equals("sum")) {
                    sb.append(stack.sum());
                } else if (queue.equals("pop")) {
                    sb.append(stack.pop());
                } else if(queue.equals("average")) {
                    sb.append(stack.average());
                }else{
                    sb.append(stack.count());
                }
                sb.append("\n");
            }
 
        }
        System.out.println(sb);
    }

    // Your code here
    Object[] data;
    int lastIndex = 0;
    double total = 0;

    public Stack_EIUSTACK(int capacity) {
        data = new Object[capacity];
    }

    public int count() {
        // Your code here
        return lastIndex;
    }

    public double sum() {
        // Your code here
        // T number;
        // number.doubleValue();

        return total;
    }

    public double average() {
        // Your code here
        return total / lastIndex;
    }

    /**
     * @description: add item when stack is not full
     */
    public void push(T item) {
        // Sample: data[lastIndex++] = item;
        // Your code here
        if (lastIndex < data.length) {
            data[lastIndex++] = item;
            total += (int) item;
        }
    }

    /**
     * @return: return and remove top item, or null when stack is empty
     */
    public T pop() {
        // Your code here
        if (lastIndex > 0) {
            T res = (T) data[lastIndex - 1];
            total -= (int) res;
            data[lastIndex - 1] = null;
            lastIndex--;
            return res;
        }
        return null;
    }

    /**
     * @return: return top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        // Sample return (T) data[lastIndex - 1];
        // Your code here
        if (lastIndex > 0) {
            return (T) data[lastIndex - 1];
        }
        return null;
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