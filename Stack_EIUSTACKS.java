import java.io.*;
import java.util.*;

public class Stack_EIUSTACKS<T extends Number> {
    private Object[] data;
    private int lastIndex = 0;

    public Stack_EIUSTACKS(int capacity) {
        data = new Object[capacity];
    }

    public int count() {
        return lastIndex;
    }

    public double sum() {
        double total = 0;
        for (int i = 0; i < lastIndex; i++) {
            total += ((Number) data[i]).doubleValue();
        }
        return total;
    }

    public double average() {
        return lastIndex == 0 ? 0 : sum() / lastIndex;
    }

    public void push(T item) {
        if (lastIndex < data.length) {
            data[lastIndex++] = item;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (lastIndex == 0) return null;
        return (T) data[--lastIndex];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (lastIndex == 0) return null;
        return (T) data[lastIndex - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Stack_EIUSTACKS<Integer> stack = new Stack_EIUSTACKS<>(n);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer popped = stack.pop();
                    if (popped != null) output.append(popped).append("\n");
                    break;
                case "peek":
                    Integer peeked = stack.peek();
                    if (peeked != null) output.append(peeked).append("\n");
                    break;
                case "sum":
                    output.append(stack.sum()).append("\n");
                    break;
                case "average":
                    output.append(stack.average()).append("\n");
                    break;
            }
        }
        System.out.print(output);
    }
}